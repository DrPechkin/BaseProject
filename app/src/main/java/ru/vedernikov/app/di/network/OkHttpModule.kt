package ru.vedernikov.app.di.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import ru.vedernikov.f_debug.DebugInteractor
import java.util.concurrent.TimeUnit
import javax.inject.Named

private const val NETWORK_TIMEOUT = 30L // sec
const val MAIN_OKHTTP = "MainOkHttp"

@Module
@InstallIn(SingletonComponent::class)
object OkHttpModule {

    @Provides
    @Named(MAIN_OKHTTP)
    fun provideMainOkHttpClient(
        debugInteractor: DebugInteractor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)

            debugInteractor.configureOkHttp(this)

        }.build()
    }
}