package ru.vedernikov.f_debug.debug

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.vedernikov.base.ActivityRoute
import ru.vedernikov.base.BaseActivityView
import ru.vedernikov.f_debug.Screens
import ru.vedernikov.f_debug.fcm.FcmScreen
import ru.vedernikov.f_debug.server_settings.ServerSettingsDebugScreen
import ru.vedernikov.f_debug.ui.theme.DebugMenuTheme

class DebugActivityView : BaseActivityView() {

    companion object : ActivityRoute {

        override fun prepareIntent(context: Context): Intent {
            return Intent(context, DebugActivityView::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DebugMenuTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.Debug.route
                    ) {
                        composable(route = Screens.Debug.route) {
                            DebugScreen(navController)
                        }
                        composable(route = Screens.Fcm.route) {
                            FcmScreen()
                        }
                         composable(route = Screens.ServerSettings.route) {
                             ServerSettingsDebugScreen()
                         }
                    }
                }
            }
        }
    }
}