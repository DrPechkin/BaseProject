package ru.vedernikov.app.di.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.vedernikov.f_debug.DebugInteractor
import ru.vedernikov.i_network.BaseUrl
import ru.vedernikov.i_network.BaseUrls
import ru.vedernikov.i_network.type.ServerType
import javax.inject.Named

private const val MAIN_RETROFIT = "Main_Retrofit"


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Named(MAIN_RETROFIT)
    fun provideMainRetrofit(
        @Named(MAIN_OKHTTP) okHttpClient: OkHttpClient,
        baseUrl: BaseUrl,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(baseUrl.toString())
            .build()
    }

    @Provides
    fun provideServerType(debugInteractor: DebugInteractor): ServerType {
        return debugInteractor.serverType
    }

    @Provides
    internal fun provideGson(): Gson {
        return GsonBuilder()
            .create()
    }

    @Provides
    internal fun provideBaseUrl(serverType: ServerType): BaseUrl {
        return when (serverType) {
            ServerType.MOCK -> BaseUrl(BaseUrls.Mock.API, BaseUrls.Mock.VERSION)
            ServerType.TEST -> BaseUrl(BaseUrls.Test.API, BaseUrls.Test.VERSION)
            ServerType.PROD -> BaseUrl(BaseUrls.Prod.API, BaseUrls.Prod.VERSION)
        }
    }
}