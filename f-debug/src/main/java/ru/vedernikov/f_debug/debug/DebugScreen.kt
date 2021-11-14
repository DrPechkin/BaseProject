package ru.vedernikov.f_debug.debug

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import ru.vedernikov.f_debug.R
import ru.vedernikov.f_debug.Screens
import ru.vedernikov.f_debug.ui.theme.DebugMenuTheme

@Composable
fun DebugScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            DebugMenuItem(stringResource(id = R.string.debug_show_app_info_debug_item)) {

            }
        }
        item {
            DebugMenuItem(stringResource(id = R.string.debug_show_server_settings_debug_item)) {

            }
        }
        item {
            DebugMenuItem(stringResource(id = R.string.debug_show_fcm_token_debug_item)) {
                navController.navigate(Screens.Fcm.route)
            }
        }
        item {
            DebugMenuItem(stringResource(id = R.string.debug_show_memory_debug_item)) {

            }
        }
        item {
            DebugMenuItem(stringResource(id = R.string.debug_show_developer_tools_debug_item)) {

            }
        }
        item {
            DebugMenuItem(stringResource(id = R.string.debug_show_app_settings_debug_item)) {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DebugScreenPreview() {
    DebugMenuTheme {
        DebugScreen(NavController(LocalContext.current))
    }
}