package ru.vedernikov.f_debug.server_settings.reboot

import android.content.Context
import android.content.Intent
import ru.vedernikov.base.ActivityRoute

class DebugLauncherActivityRoute : ActivityRoute {

    override fun prepareIntent(context: Context): Intent {
        return context.packageManager.getLaunchIntentForPackage(context.packageName)!!
    }
}