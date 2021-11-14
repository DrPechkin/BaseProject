package ru.vedernikov.f_debug.injector

import android.app.Application
import ru.vedernikov.f_debug.DebugInteractor
import ru.vedernikov.f_debug.server_settings.reboot.DebugRebootInteractor

object DebugAppInjector {

    lateinit var debugInteractor: DebugInteractor

    fun initInjector(app: Application) {
        debugInteractor = DebugInteractor(app, DebugRebootInteractor(app.applicationContext))
    }
}