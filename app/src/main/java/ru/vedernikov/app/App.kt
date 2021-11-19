package ru.vedernikov.app

import android.app.Application
import ru.vedernikov.f_debug.injector.DebugAppInjector
import ru.vedernikov.i_network.type.ServerTypeContainer

class App : Application() {


    override fun onCreate() {
        super.onCreate()

        DebugAppInjector.initInjector(this)
        DebugAppInjector.debugInteractor.onCreateApp(R.mipmap.ic_launcher)

        initServerType()
    }

    private fun initServerType() {
        ServerTypeContainer.serverType = DebugAppInjector.debugInteractor.serverType
    }
}