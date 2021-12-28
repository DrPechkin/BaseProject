package ru.vedernikov.f_debug.storage

import android.content.SharedPreferences
import androidx.core.content.edit
import ru.vedernikov.base.NO_BACKUP_SHARED_PREF
import ru.vedernikov.i_network.type.ServerType
import javax.inject.Inject
import javax.inject.Named

private const val DEBUG_SERVER_TYPE = "DEBUG_SERVER_TYPE"
private const val REQUEST_DELAY = "REQUEST_DELAY"

class DebugServerSettingsStorage @Inject constructor(
    @Named(NO_BACKUP_SHARED_PREF) private val noBackupSharedPref: SharedPreferences
) {

    var serverType: ServerType
        get() = ServerType.getById(noBackupSharedPref.getInt(DEBUG_SERVER_TYPE, ServerType.TEST.id))
        set(value) = noBackupSharedPref.edit { putInt(DEBUG_SERVER_TYPE, value.id) }

    var requestDelay: Long
        get() = noBackupSharedPref.getLong(REQUEST_DELAY, 0L)
        set(value) = noBackupSharedPref.edit { putLong(REQUEST_DELAY, value) }
}