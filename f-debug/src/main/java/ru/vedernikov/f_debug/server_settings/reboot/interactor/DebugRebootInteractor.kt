package ru.vedernikov.f_debug.server_settings.reboot.interactor

import android.content.Context
import com.jakewharton.processphoenix.ProcessPhoenix
import ru.vedernikov.base.ActivityRoute
import javax.inject.Inject

class DebugRebootInteractor @Inject constructor() {

    /**
     * Полный перезапуск приложения
     *
     * @param activityRoute route активности, которая будет запущена после перезапуска
     */
    fun reboot(context: Context, activityRoute: ActivityRoute) {
        ProcessPhoenix.triggerRebirth(context, activityRoute.prepareIntent(context))
    }
}