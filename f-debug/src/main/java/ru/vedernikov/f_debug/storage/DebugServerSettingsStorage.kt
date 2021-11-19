package ru.vedernikov.f_debug.storage

import android.content.SharedPreferences
import ru.vedernikov.i_network.type.ServerType

private const val DEBUG_SERVER_TYPE = "DEBUG_SERVER_TYPE"
private const val REQUEST_DELAY = "REQUEST_DELAY"

class DebugServerSettingsStorage(
    private val noBackupSharedPref: SharedPreferences
) {

    var serverType: ServerType
        get() = ServerType.getById(noBackupSharedPref.getInt(DEBUG_SERVER_TYPE, ServerType.TEST.id))
        set(value) = noBackupSharedPref.edit().putInt(DEBUG_SERVER_TYPE, value.id).apply()

    var requestDelay: Long
        get() = noBackupSharedPref.getLong(REQUEST_DELAY, 0L)
        set(value) = noBackupSharedPref.edit().putLong(REQUEST_DELAY, value).apply()
}