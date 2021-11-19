package ru.vedernikov.f_debug.injector

import android.app.Application
import android.content.Context.MODE_PRIVATE
import ru.vedernikov.f_debug.DebugInteractor
import ru.vedernikov.f_debug.server_settings.reboot.DebugRebootInteractor
import ru.vedernikov.f_debug.storage.DebugServerSettingsStorage

object DebugAppInjector {

    lateinit var debugInteractor: DebugInteractor

    fun initInjector(app: Application) {
        debugInteractor = DebugInteractor(
            app,
            DebugServerSettingsStorage(app.getSharedPreferences("noBackupSharedPref", MODE_PRIVATE)),
            DebugRebootInteractor(app.applicationContext)
        )
    }
}