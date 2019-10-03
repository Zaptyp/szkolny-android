/*
 * Copyright (c) Kuba Szczodrzyński 2019-10-1.
 */

package pl.szczodrzynski.edziennik.api.v2.librus

import pl.szczodrzynski.edziennik.R
import pl.szczodrzynski.edziennik.api.v2.LOGIN_METHOD_LIBRUS_API
import pl.szczodrzynski.edziennik.api.v2.LOGIN_METHOD_LIBRUS_MESSAGES
import pl.szczodrzynski.edziennik.api.v2.LOGIN_METHOD_LIBRUS_PORTAL
import pl.szczodrzynski.edziennik.api.v2.LOGIN_METHOD_LIBRUS_SYNERGIA
import pl.szczodrzynski.edziennik.api.v2.librus.data.DataLibrus
import pl.szczodrzynski.edziennik.api.v2.librus.login.LoginLibrusApi
import pl.szczodrzynski.edziennik.api.v2.librus.login.LoginLibrusMessages
import pl.szczodrzynski.edziennik.api.v2.librus.login.LoginLibrusPortal
import pl.szczodrzynski.edziennik.api.v2.librus.login.LoginLibrusSynergia
import pl.szczodrzynski.edziennik.utils.Utils

class LibrusLogin(val data: DataLibrus, val onSuccess: () -> Unit) {
    companion object {
        private const val TAG = "LibrusLogin"
    }

    private var cancelled = false

    init {
        nextLoginMethod(onSuccess)
    }

    private fun nextLoginMethod(onSuccess: () -> Unit) {
        if (data.targetLoginMethodIds.isEmpty()) {
            onSuccess()
            return
        }
        useLoginMethod(data.targetLoginMethodIds.removeAt(0)) { usedMethodId ->
            if (usedMethodId != -1)
                data.loginMethods.add(usedMethodId)
            if (cancelled) {
                onSuccess()
                return@useLoginMethod
            }
            nextLoginMethod(onSuccess)
        }
    }

    private fun useLoginMethod(loginMethodId: Int, onSuccess: (usedMethodId: Int) -> Unit) {
        // this should never be true
        if (data.loginMethods.contains(loginMethodId)) {
            onSuccess(-1)
            return
        }
        Utils.d(TAG, "Using login method $loginMethodId")
        when (loginMethodId) {
            LOGIN_METHOD_LIBRUS_PORTAL -> {
                data.startProgress(R.string.edziennik_progress_login_librus_portal)
                LoginLibrusPortal(data) { onSuccess(loginMethodId) }
            }
            LOGIN_METHOD_LIBRUS_API -> {
                data.startProgress(R.string.edziennik_progress_login_librus_api)
                LoginLibrusApi(data) { onSuccess(loginMethodId) }
            }
            LOGIN_METHOD_LIBRUS_SYNERGIA -> {
                data.startProgress(R.string.edziennik_progress_login_librus_synergia)
                LoginLibrusSynergia(data) { onSuccess(loginMethodId) }
            }
            LOGIN_METHOD_LIBRUS_MESSAGES -> {
                data.startProgress(R.string.edziennik_progress_login_librus_messages)
                LoginLibrusMessages(data) { onSuccess(loginMethodId) }
            }
        }
    }
}