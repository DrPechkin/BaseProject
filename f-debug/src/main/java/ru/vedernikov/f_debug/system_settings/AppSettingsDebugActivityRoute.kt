package ru.vedernikov.f_debug.system_settings

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import ru.vedernikov.base.ActivityRoute

private const val SCHEME_PACKAGE = "package"

class AppSettingsDebugActivityRoute : ActivityRoute {

    override fun prepareIntent(context: Context): Intent {
        return Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            .apply { data = Uri.fromParts(SCHEME_PACKAGE, context.packageName, null) }
    }
}