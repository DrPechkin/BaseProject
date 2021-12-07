package ru.vedernikov.f_debug

import okhttp3.OkHttpClient
import ru.vedernikov.i_network.type.ServerType

class DebugInteractor {

    var serverType: ServerType = ServerType.PROD

    fun onCreateApp(icon: Int) { /* no action */
    }

    fun mustNotInitializeApp() = false

    fun configureOkHttp(builder: OkHttpClient.Builder) { /* no action */ }
}