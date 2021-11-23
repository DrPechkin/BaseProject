package ru.vedernikov.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ru.vedernikov.f_debug.DebugInteractor
import ru.vedernikov.i_network.type.ServerTypeContainer
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {

    @Inject
    lateinit var debugInteractor: DebugInteractor

    override fun onCreate() {
        super.onCreate()

        debugInteractor.onCreateApp(R.mipmap.ic_launcher)

        Timber.plant(Timber.DebugTree())
        initServerType()
    }

    private fun initServerType() {
        ServerTypeContainer.serverType = debugInteractor.serverType
        Timber.i("Current server type: ${ServerTypeContainer.serverType.name}")
    }
}