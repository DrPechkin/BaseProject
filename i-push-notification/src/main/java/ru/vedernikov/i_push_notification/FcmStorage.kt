package ru.vedernikov.i_push_notification

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

/**
 * Хранилище fcm-токена
 */
class FcmStorage @Inject constructor(private val noBackupSharedPref: SharedPreferences) {

    companion object {
        private const val KEY_FCM_TOKEN = "FCM_TOKEN"
    }

    var fcmToken: String
        get() = noBackupSharedPref.getString(KEY_FCM_TOKEN, "").orEmpty()
        set(value) = noBackupSharedPref.edit { putString(KEY_FCM_TOKEN, value) }

    fun clear() {
        noBackupSharedPref.edit { putString(KEY_FCM_TOKEN, "") }
    }
}