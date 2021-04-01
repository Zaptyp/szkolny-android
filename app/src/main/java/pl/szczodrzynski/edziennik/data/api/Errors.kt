/*
 * Copyright (c) Kuba Szczodrzyński 2019-9-21.
 */

package pl.szczodrzynski.edziennik.data.api

/*const val CODE_OTHER                                        = 0
const val CODE_OK                                           = 1
const val CODE_NO_INTERNET                                  = 10
const val CODE_SSL_ERROR                                    = 13
const val CODE_ARCHIVED                                     = 5
const val CODE_MAINTENANCE                                  = 6
const val CODE_LOGIN_ERROR                                  = 7
const val CODE_ACCOUNT_MISMATCH                             = 8
const val CODE_APP_SERVER_ERROR                             = 9
const val CODE_MULTIACCOUNT_SETUP                           = 12
const val CODE_TIMEOUT                                      = 11
const val CODE_PROFILE_NOT_FOUND                            = 14
const val CODE_ATTACHMENT_NOT_AVAILABLE                     = 28
const val CODE_INVALID_LOGIN                                = 2
const val CODE_INVALID_SERVER_ADDRESS                       = 21
const val CODE_INVALID_SCHOOL_NAME                          = 22
const val CODE_INVALID_DEVICE                               = 23
const val CODE_OLD_PASSWORD                                 = 4
const val CODE_INVALID_TOKEN                                = 24
const val CODE_EXPIRED_TOKEN                                = 27
const val CODE_INVALID_SYMBOL                               = 25
const val CODE_INVALID_PIN                                  = 26
const val CODE_LIBRUS_NOT_ACTIVATED                         = 29
const val CODE_SYNERGIA_NOT_ACTIVATED                       = 32
const val CODE_LIBRUS_DISCONNECTED                          = 31
const val CODE_PROFILE_ARCHIVED                             = 30*/

const val ERROR_APP_CRASH                                   = 1
const val ERROR_EXCEPTION                                   = 2
const val ERROR_API_EXCEPTION                               = 3
const val ERROR_MESSAGE_NOT_SENT                            = 10

const val ERROR_REQUEST_FAILURE                             = 50
const val ERROR_REQUEST_HTTP_400                            = 51
const val ERROR_REQUEST_HTTP_401                            = 52
const val ERROR_REQUEST_HTTP_403                            = 53
const val ERROR_REQUEST_HTTP_404                            = 54
const val ERROR_REQUEST_HTTP_405                            = 55
const val ERROR_REQUEST_HTTP_410                            = 56
const val ERROR_REQUEST_HTTP_424                            = 57
const val ERROR_REQUEST_HTTP_500                            = 58
const val ERROR_REQUEST_HTTP_503                            = 59
const val ERROR_REQUEST_FAILURE_HOSTNAME_NOT_FOUND          = 60
const val ERROR_REQUEST_FAILURE_TIMEOUT                     = 61
const val ERROR_REQUEST_FAILURE_NO_INTERNET                 = 62
const val ERROR_REQUEST_FAILURE_SSL_ERROR                   = 63
const val ERROR_RESPONSE_EMPTY                              = 100
const val ERROR_LOGIN_DATA_MISSING                          = 101
const val ERROR_PROFILE_MISSING                             = 105
const val ERROR_PROFILE_ARCHIVED                            = 106
const val ERROR_INVALID_LOGIN_MODE                          = 110
const val ERROR_LOGIN_METHOD_NOT_SATISFIED                  = 111
const val ERROR_NOT_IMPLEMENTED                             = 112
const val ERROR_FILE_DOWNLOAD                               = 113

const val ERROR_NO_STUDENTS_IN_ACCOUNT                      = 115

const val ERROR_CAPTCHA_NEEDED                              = 3000
const val ERROR_CAPTCHA_LIBRUS_PORTAL                       = 3001

const val ERROR_API_PDO_ERROR                               = 5000
const val ERROR_API_INVALID_CLIENT                          = 5001
const val ERROR_API_INVALID_ARGUMENT                        = 5002
const val ERROR_API_INVALID_SIGNATURE                       = 5003
const val ERROR_API_MISSING_SCOPES                          = 5004
const val ERROR_API_RESOURCE_NOT_FOUND                      = 5005
const val ERROR_API_INTERNAL_SERVER_ERROR                   = 5006
const val ERROR_API_PHP_E_ERROR                             = 5007
const val ERROR_API_PHP_E_WARNING                           = 5008
const val ERROR_API_PHP_E_PARSE                             = 5009
const val ERROR_API_PHP_E_NOTICE                            = 5010
const val ERROR_API_PHP_E_OTHER                             = 5011
const val ERROR_API_MAINTENANCE                             = 5012
const val ERROR_API_MISSING_ARGUMENT                        = 5013
const val ERROR_API_PAYLOAD_EMPTY                           = 5014
const val ERROR_API_INVALID_ACTION                          = 5015
const val ERROR_API_UPDATE_NOT_FOUND                        = 5016
const val ERROR_API_INVALID_DEVICEID_USERCODE               = 5017
const val ERROR_API_INVALID_PAIRTOKEN                       = 5018
const val ERROR_API_INVALID_BROWSERID                       = 5019
const val ERROR_API_INVALID_DEVICEID                        = 5020
const val ERROR_API_INVALID_DEVICEID_BROWSERID              = 5021
const val ERROR_API_HELP_CATEGORY_NOT_FOUND                 = 5022

const val CODE_INTERNAL_LIBRUS_ACCOUNT_410                  = 120
const val CODE_INTERNAL_LIBRUS_SYNERGIA_EXPIRED             = 121
const val ERROR_LOGIN_LIBRUS_API_CAPTCHA_NEEDED             = 124
const val ERROR_LOGIN_LIBRUS_API_CONNECTION_PROBLEMS        = 125
const val ERROR_LOGIN_LIBRUS_API_INVALID_CLIENT             = 126
const val ERROR_LOGIN_LIBRUS_API_REG_ACCEPT_NEEDED          = 127
const val ERROR_LOGIN_LIBRUS_API_CHANGE_PASSWORD_ERROR      = 128
const val ERROR_LOGIN_LIBRUS_API_PASSWORD_CHANGE_REQUIRED   = 129
const val ERROR_LOGIN_LIBRUS_API_INVALID_LOGIN              = 130
const val ERROR_LOGIN_LIBRUS_API_OTHER                      = 131
const val ERROR_LOGIN_LIBRUS_PORTAL_CSRF_MISSING            = 132
const val ERROR_LOGIN_LIBRUS_PORTAL_NOT_ACTIVATED           = 133
const val ERROR_LOGIN_LIBRUS_PORTAL_ACTION_ERROR            = 134
const val ERROR_LOGIN_LIBRUS_PORTAL_SYNERGIA_TOKEN_MISSING  = 139
const val ERROR_LIBRUS_API_TOKEN_EXPIRED                    = 140
const val ERROR_LIBRUS_API_INSUFFICIENT_SCOPES              = 141
const val ERROR_LIBRUS_API_OTHER                            = 142
const val ERROR_LIBRUS_API_ACCESS_DENIED                    = 143
const val ERROR_LIBRUS_API_RESOURCE_NOT_FOUND               = 144
const val ERROR_LIBRUS_API_DATA_NOT_FOUND                   = 145
const val ERROR_LIBRUS_API_TIMETABLE_NOT_PUBLIC             = 146
const val ERROR_LIBRUS_API_RESOURCE_ACCESS_DENIED           = 147
const val ERROR_LIBRUS_API_INVALID_REQUEST_PARAMS           = 148
const val ERROR_LIBRUS_API_INCORRECT_ENDPOINT               = 149
const val ERROR_LIBRUS_API_LUCKY_NUMBER_NOT_ACTIVE          = 150
const val ERROR_LIBRUS_API_NOTES_NOT_ACTIVE                 = 151
const val ERROR_LOGIN_LIBRUS_SYNERGIA_NO_TOKEN              = 152
const val ERROR_LOGIN_LIBRUS_SYNERGIA_TOKEN_INVALID         = 153
const val ERROR_LOGIN_LIBRUS_SYNERGIA_NO_SESSION_ID         = 154
const val ERROR_LIBRUS_MESSAGES_ACCESS_DENIED               = 155
const val ERROR_LIBRUS_SYNERGIA_ACCESS_DENIED               = 156
const val ERROR_LOGIN_LIBRUS_MESSAGES_NO_SESSION_ID         = 157
const val ERROR_LIBRUS_PORTAL_ACCESS_DENIED                 = 158
const val ERROR_LIBRUS_PORTAL_API_DISABLED                  = 159
const val ERROR_LIBRUS_PORTAL_SYNERGIA_DISCONNECTED         = 160
const val ERROR_LIBRUS_PORTAL_OTHER                         = 161
const val ERROR_LIBRUS_PORTAL_SYNERGIA_NOT_FOUND            = 162
const val ERROR_LOGIN_LIBRUS_PORTAL_OTHER                   = 163
const val ERROR_LOGIN_LIBRUS_PORTAL_CODE_EXPIRED            = 164
const val ERROR_LOGIN_LIBRUS_PORTAL_CODE_REVOKED            = 165
const val ERROR_LOGIN_LIBRUS_PORTAL_NO_CLIENT_ID            = 166
const val ERROR_LOGIN_LIBRUS_PORTAL_NO_CODE                 = 167
const val ERROR_LOGIN_LIBRUS_PORTAL_NO_REFRESH              = 168
const val ERROR_LOGIN_LIBRUS_PORTAL_NO_REDIRECT             = 169
const val ERROR_LOGIN_LIBRUS_PORTAL_UNSUPPORTED_GRANT       = 170
const val ERROR_LOGIN_LIBRUS_PORTAL_INVALID_CLIENT_ID       = 171
const val ERROR_LOGIN_LIBRUS_PORTAL_REFRESH_INVALID         = 172
const val ERROR_LOGIN_LIBRUS_PORTAL_REFRESH_REVOKED         = 173
const val ERROR_LIBRUS_SYNERGIA_OTHER                       = 174
const val ERROR_LIBRUS_SYNERGIA_MAINTENANCE                 = 175
const val ERROR_LIBRUS_MESSAGES_MAINTENANCE                 = 176
const val ERROR_LIBRUS_MESSAGES_ERROR                       = 177
const val ERROR_LIBRUS_MESSAGES_OTHER                       = 178
const val ERROR_LOGIN_LIBRUS_MESSAGES_INVALID_LOGIN         = 179
const val ERROR_LOGIN_LIBRUS_PORTAL_INVALID_LOGIN           = 180
const val ERROR_LIBRUS_API_MAINTENANCE                      = 181
const val ERROR_LIBRUS_PORTAL_MAINTENANCE                   = 182
const val ERROR_LIBRUS_API_NOTICEBOARD_PROBLEM              = 183
const val ERROR_LOGIN_LIBRUS_PORTAL_CSRF_EXPIRED            = 184
const val ERROR_LIBRUS_API_DEVICE_REGISTERED                = 185
const val ERROR_LIBRUS_MESSAGES_NOT_FOUND                   = 186
const val ERROR_LOGIN_LIBRUS_API_INVALID_REQUEST            = 187
const val ERROR_LIBRUS_MESSAGES_ATTACHMENT_NOT_FOUND        = 188
const val ERROR_LOGIN_LIBRUS_MESSAGES_TIMEOUT               = 189

const val ERROR_LOGIN_MOBIDZIENNIK_WEB_INVALID_LOGIN        = 201
const val ERROR_LOGIN_MOBIDZIENNIK_WEB_OLD_PASSWORD         = 202
const val ERROR_LOGIN_MOBIDZIENNIK_WEB_INVALID_DEVICE       = 203
const val ERROR_LOGIN_MOBIDZIENNIK_WEB_ARCHIVED             = 204
const val ERROR_LOGIN_MOBIDZIENNIK_WEB_MAINTENANCE          = 205
const val ERROR_LOGIN_MOBIDZIENNIK_WEB_INVALID_ADDRESS      = 206
const val ERROR_LOGIN_MOBIDZIENNIK_WEB_OTHER                = 210
const val ERROR_MOBIDZIENNIK_WEB_ACCESS_DENIED              = 211
const val ERROR_MOBIDZIENNIK_WEB_NO_SESSION_KEY             = 212
const val ERROR_MOBIDZIENNIK_WEB_NO_SESSION_VALUE           = 216
const val ERROR_MOBIDZIENNIK_WEB_NO_SERVER_ID               = 213
const val ERROR_MOBIDZIENNIK_WEB_INVALID_RESPONSE           = 214
const val ERROR_LOGIN_MOBIDZIENNIK_WEB_NO_SESSION_ID        = 215
const val ERROR_LOGIN_MOBIDZIENNIK_API2_INVALID_LOGIN       = 216
const val ERROR_LOGIN_MOBIDZIENNIK_API2_OTHER               = 217
const val ERROR_MOBIDZIENNIK_WEB_SERVER_PROBLEM             = 218

const val ERROR_LOGIN_VULCAN_INVALID_SYMBOL                 = 301
const val ERROR_LOGIN_VULCAN_INVALID_TOKEN                  = 302
const val ERROR_LOGIN_VULCAN_INVALID_PIN_0_REMAINING        = 310
const val ERROR_LOGIN_VULCAN_INVALID_PIN_1_REMAINING        = 311
const val ERROR_LOGIN_VULCAN_INVALID_PIN_2_REMAINING        = 312
const val ERROR_LOGIN_VULCAN_EXPIRED_TOKEN                  = 321
const val ERROR_LOGIN_VULCAN_NO_PUPILS                      = 331
const val ERROR_VULCAN_ATTACHMENT_DOWNLOAD                  = 343
const val ERROR_VULCAN_WEB_DATA_MISSING                     = 344
const val ERROR_VULCAN_WEB_429                              = 345
const val ERROR_VULCAN_WEB_OTHER                            = 346
const val ERROR_VULCAN_WEB_NO_CERTIFICATE                   = 347
const val ERROR_VULCAN_WEB_NO_REGISTER                      = 348
const val ERROR_VULCAN_WEB_CERTIFICATE_EXPIRED              = 349
const val ERROR_VULCAN_WEB_LOGGED_OUT                       = 350
const val ERROR_VULCAN_WEB_CERTIFICATE_POST_FAILED          = 351
const val ERROR_VULCAN_WEB_GRADUATE_ACCOUNT                 = 352
const val ERROR_VULCAN_WEB_NO_SCHOOLS                       = 353
const val ERROR_VULCAN_HEBE_OTHER                           = 354
const val ERROR_VULCAN_HEBE_SIGNATURE_ERROR                 = 360
const val ERROR_VULCAN_HEBE_INVALID_PAYLOAD                 = 361
const val ERROR_VULCAN_HEBE_FIREBASE_ERROR                  = 362
const val ERROR_VULCAN_HEBE_CERTIFICATE_GONE                = 363
const val ERROR_VULCAN_HEBE_SERVER_ERROR                    = 364
const val ERROR_VULCAN_HEBE_ENTITY_NOT_FOUND                = 365
const val ERROR_VULCAN_API_DEPRECATED                       = 390

const val ERROR_LOGIN_EDUDZIENNIK_WEB_INVALID_LOGIN         = 501
const val ERROR_LOGIN_EDUDZIENNIK_WEB_OTHER                 = 510
const val ERROR_LOGIN_EDUDZIENNIK_WEB_NO_SESSION_ID         = 511
const val ERROR_EDUDZIENNIK_WEB_LIMITED_ACCESS              = 521
const val ERROR_EDUDZIENNIK_WEB_SESSION_EXPIRED             = 522
const val ERROR_EDUDZIENNIK_WEB_TEAM_MISSING                = 530

const val ERROR_LOGIN_PODLASIE_API_INVALID_TOKEN            = 601
const val ERROR_LOGIN_PODLASIE_API_DEVICE_LIMIT             = 602
const val ERROR_PODLASIE_API_NO_TOKEN                       = 630
const val ERROR_PODLASIE_API_OTHER                          = 631
const val ERROR_PODLASIE_API_DATA_MISSING                   = 632

const val ERROR_TEMPLATE_WEB_OTHER                          = 801

const val EXCEPTION_API_TASK                                = 900
const val EXCEPTION_LOGIN_LIBRUS_API_TOKEN                  = 901
const val EXCEPTION_LOGIN_LIBRUS_PORTAL_TOKEN               = 902
const val EXCEPTION_LIBRUS_PORTAL_SYNERGIA_TOKEN            = 903
const val EXCEPTION_LIBRUS_API_REQUEST                      = 904
const val EXCEPTION_LIBRUS_SYNERGIA_REQUEST                 = 905
const val EXCEPTION_MOBIDZIENNIK_WEB_REQUEST                = 906
const val EXCEPTION_MOBIDZIENNIK_WEB_FILE_REQUEST           = 908
const val EXCEPTION_LIBRUS_MESSAGES_FILE_REQUEST            = 909
const val EXCEPTION_NOTIFY                                  = 910
const val EXCEPTION_LIBRUS_MESSAGES_REQUEST                 = 911
const val EXCEPTION_EDUDZIENNIK_WEB_REQUEST                 = 920
const val EXCEPTION_EDUDZIENNIK_FILE_REQUEST                = 921
const val ERROR_ONEDRIVE_DOWNLOAD                           = 930
const val EXCEPTION_VULCAN_WEB_LOGIN                        = 931
const val EXCEPTION_VULCAN_WEB_REQUEST                      = 932
const val EXCEPTION_PODLASIE_API_REQUEST                    = 940
const val EXCEPTION_VULCAN_HEBE_REQUEST                     = 950

const val LOGIN_NO_ARGUMENTS                                = 1201
