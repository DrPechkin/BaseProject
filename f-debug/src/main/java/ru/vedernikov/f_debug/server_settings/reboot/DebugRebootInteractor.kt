package ru.vedernikov.f_debug.server_settings.reboot

import android.content.Context
import ru.vedernikov.base.ActivityRoute

class DebugRebootInteractor(private val context: Context) {

    /**
     * Полный перезапуск приложения
     *
     * @param activityRoute route активности, которая будет запущена после перезапуска
     */
    fun reboot(activityRoute: ActivityRoute) {
       // ProcessPhoenix.triggerRebirth(context, activityRoute.prepareIntent(context))
        // todo запустить перезапуск
    }
}