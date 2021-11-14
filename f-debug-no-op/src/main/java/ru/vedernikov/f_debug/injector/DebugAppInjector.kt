package ru.vedernikov.f_debug.injector

import android.app.Application
import ru.vedernikov.f_debug.DebugInteractor

object DebugAppInjector {

    lateinit var debugInteractor: DebugInteractor

    fun initInjector(app: Application) {
        debugInteractor = DebugInteractor()
    }
}