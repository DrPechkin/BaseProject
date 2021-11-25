package ru.vedernikov.f_debug.system_settings

import android.content.Context
import android.content.Intent
import android.provider.Settings
import ru.vedernikov.base.ActivityRoute

class DeveloperToolsDebugActivityRoute : ActivityRoute {
    override fun prepareIntent(context: Context): Intent {
        return Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
    }
}