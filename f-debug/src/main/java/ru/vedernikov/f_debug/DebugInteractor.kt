package ru.vedernikov.f_debug

import android.app.Application
import ru.vedernikov.base.ActivityRoute
import ru.vedernikov.f_debug.notification.DebugNotificationBuilder
import ru.vedernikov.f_debug.server_settings.reboot.DebugRebootInteractor

class DebugInteractor(
    private val application: Application,
    private val rebootInteractor: DebugRebootInteractor
) {

    fun onCreateApp(icon: Int) {
        handleFirstActivityOpening(icon)
    }

    fun reboot(route: ActivityRoute) {
        rebootInteractor.reboot(route)
    }

    private fun handleFirstActivityOpening(icon: Int) {
        DebugNotificationBuilder.showDebugNotification(application, icon)
    }
}