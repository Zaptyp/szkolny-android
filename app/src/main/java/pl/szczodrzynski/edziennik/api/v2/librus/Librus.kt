/*
 * Copyright (c) Kuba Szczodrzyński 2019-9-21.
 */

package pl.szczodrzynski.edziennik.api.v2.librus

import android.util.Log
import pl.szczodrzynski.edziennik.App
import pl.szczodrzynski.edziennik.api.v2.CODE_INTERNAL_LIBRUS_ACCOUNT_410
import pl.szczodrzynski.edziennik.api.v2.LOGIN_METHOD_NOT_NEEDED
import pl.szczodrzynski.edziennik.api.v2.endpoints
import pl.szczodrzynski.edziennik.api.v2.interfaces.EdziennikCallback
import pl.szczodrzynski.edziennik.api.v2.interfaces.EdziennikInterface
import pl.szczodrzynski.edziennik.api.v2.librus.data.DataLibrus
import pl.szczodrzynski.edziennik.api.v2.librus.data.LibrusData
import pl.szczodrzynski.edziennik.api.v2.librus.login.LibrusLogin
import pl.szczodrzynski.edziennik.api.v2.librusLoginMethods
import pl.szczodrzynski.edziennik.api.v2.models.ApiError
import pl.szczodrzynski.edziennik.api.v2.models.Endpoint
import pl.szczodrzynski.edziennik.data.db.modules.api.*
import pl.szczodrzynski.edziennik.data.db.modules.login.LoginStore
import pl.szczodrzynski.edziennik.data.db.modules.profiles.Profile
import pl.szczodrzynski.edziennik.utils.Utils.d

class Librus(val app: App, val profile: Profile?, val loginStore: LoginStore, val callback: EdziennikCallback) : EdziennikInterface {
    companion object {
        private const val TAG = "Librus"
    }

    val internalErrorList = mutableListOf<Int>()
    val data: DataLibrus
    private var cancelled = false

    init {
        data = DataLibrus(app, profile, loginStore).apply {
            callback = wrapCallback(this@Librus.callback)
        }
        data.satisfyLoginMethods()
    }

    private fun completed() {
        data.saveData()
        callback.onCompleted()
    }

    /*    _______ _                     _                  _ _   _
         |__   __| |              /\   | |                (_) | | |
            | |  | |__   ___     /  \  | | __ _  ___  _ __ _| |_| |__  _ __ ___
            | |  | '_ \ / _ \   / /\ \ | |/ _` |/ _ \| '__| | __| '_ \| '_ ` _ \
            | |  | | | |  __/  / ____ \| | (_| | (_) | |  | | |_| | | | | | | | |
            |_|  |_| |_|\___| /_/    \_\_|\__, |\___/|_|  |_|\__|_| |_|_| |_| |_|
                                           __/ |
                                          |__*/
    override fun sync(featureIds: List<Int>, viewId: Int?) {
        val possibleLoginMethods = data.loginMethods.toMutableList()

        for (loginMethod in librusLoginMethods) {
            if (loginMethod.isPossible(profile, loginStore))
                possibleLoginMethods += loginMethod.loginMethodId
        }

        //var highestLoginMethod = 0
        var endpointList = mutableListOf<Endpoint>()
        val requiredLoginMethods = mutableListOf<Int>()

        data.targetEndpointIds.clear()
        data.targetLoginMethodIds.clear()

        // get all endpoints for every feature, only if possible to login
        for (featureId in featureIds) {
            endpoints.filter {
                        it.featureId == featureId && possibleLoginMethods.containsAll(it.requiredLoginMethods)
                    }
                    .let {
                        endpointList.addAll(it)
                    }
        }

        val timestamp = System.currentTimeMillis()

        endpointList = endpointList
                // sort the endpoint list by feature ID and priority
                .sortedWith(compareBy(Endpoint::featureId, Endpoint::priority))
                // select only the most important endpoint for each feature
                .distinctBy { it.featureId }
                .toMutableList()
                // add all endpoint IDs and required login methods, filtering using timers
                .onEach { feature ->
                    feature.endpointIds.forEach { endpoint ->
                        (data.endpointTimers
                                .singleOrNull { it.endpointId == endpoint.first } ?: EndpointTimer(data.profile?.id ?: -1, endpoint.first))
                                .let { timer ->
                                    if (timer.nextSync == SYNC_ALWAYS ||
                                            (timer.viewId == viewId) ||
                                            (timer.nextSync != SYNC_NEVER && timer.nextSync < timestamp)) {
                                        data.targetEndpointIds.add(endpoint.first)
                                        requiredLoginMethods.add(endpoint.second)
                                    }
                                }
                    }
                }

        // check every login method for any dependencies
        for (loginMethodId in requiredLoginMethods) {
            var requiredLoginMethod: Int? = loginMethodId
            while (requiredLoginMethod != LOGIN_METHOD_NOT_NEEDED) {
                librusLoginMethods.singleOrNull { it.loginMethodId == requiredLoginMethod }?.let { loginMethod ->
                    if (requiredLoginMethod != null)
                        data.targetLoginMethodIds.add(requiredLoginMethod!!)
                    requiredLoginMethod = loginMethod.requiredLoginMethod(data.profile, data.loginStore)
                }
            }
        }

        // sort and distinct every login method and endpoint
        data.targetLoginMethodIds = data.targetLoginMethodIds.toHashSet().toMutableList()
        data.targetLoginMethodIds.sort()

        data.targetEndpointIds = data.targetEndpointIds.toHashSet().toMutableList()
        data.targetEndpointIds.sort()

        Log.d(TAG, "LoginMethod IDs: ${data.targetLoginMethodIds}")
        Log.d(TAG, "Endpoint IDs: ${data.targetEndpointIds}")

        LibrusLogin(data) {
            LibrusData(data) {
                completed()
            }
        }
    }

    override fun getMessage(messageId: Int) {

    }

    override fun cancel() {
        d(TAG, "Cancelled")
        cancelled = true
    }

    private fun wrapCallback(callback: EdziennikCallback): EdziennikCallback {
        return object : EdziennikCallback {
            override fun onCompleted() {
                callback.onCompleted()
            }

            override fun onProgress(step: Int) {
                callback.onProgress(step)
            }

            override fun onStartProgress(stringRes: Int) {
                callback.onStartProgress(stringRes)
            }

            override fun onError(apiError: ApiError) {
                when (apiError.errorCode) {
                    in internalErrorList -> {
                        // finish immediately if the same error occurs twice during the same sync
                        callback.onError(apiError)
                    }
                    CODE_INTERNAL_LIBRUS_ACCOUNT_410 -> {
                        internalErrorList.add(apiError.errorCode)
                        loginStore.removeLoginData("refreshToken") // force a clean login
                        //loginLibrus()
                    }
                    else -> callback.onError(apiError)
                }
            }
        }
    }
}