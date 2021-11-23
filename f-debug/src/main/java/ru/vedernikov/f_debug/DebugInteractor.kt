package ru.vedernikov.f_debug

import android.app.Application
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import okhttp3.OkHttpClient
import ru.vedernikov.base.ActivityRoute
import ru.vedernikov.f_debug.network.DelayInterceptor
import ru.vedernikov.f_debug.notification.DebugNotificationBuilder
import ru.vedernikov.f_debug.server_settings.reboot.interactor.DebugRebootInteractor
import ru.vedernikov.f_debug.storage.DebugServerSettingsStorage
import ru.vedernikov.i_network.type.ServerType
import javax.inject.Inject

class DebugInteractor @Inject constructor(
    private val application: Application,
    private val debugServerSettingsStorage: DebugServerSettingsStorage,
    private val rebootInteractor: DebugRebootInteractor
) {

    private val serverChangedPublishSubject = MutableSharedFlow<Unit>()

    val observeNeedClearSession: SharedFlow<Unit>
        get() = serverChangedPublishSubject

    //region Настройки сервера
    var serverType: ServerType
        get() = debugServerSettingsStorage.serverType
        set(value) {
            debugServerSettingsStorage.serverType = value
            serverChangedPublishSubject.tryEmit(Unit)
        }

    /**
     * Задержка между запросами на сервер в миллисекундах
     */
    var requestDelay: Long
        get() = debugServerSettingsStorage.requestDelay
        set(value) {
            debugServerSettingsStorage.requestDelay = value
        }

    /**
     * Добавляет [ChuckInterceptor], [StethoInterceptor] в [OkHttpClient] если в настройках включено
     */
    fun configureOkHttp(okHttpBuilder: OkHttpClient.Builder) {
        okHttpBuilder.addInterceptor(DelayInterceptor { requestDelay })
    }
    //endregion

    fun onCreateApp(icon: Int) {
        handleFirstActivityOpening(icon)
    }

    fun reboot(route: ActivityRoute) {
        rebootInteractor.reboot(application.applicationContext, route)
    }

    private fun handleFirstActivityOpening(icon: Int) {
        DebugNotificationBuilder.showDebugNotification(application, icon)
    }
}