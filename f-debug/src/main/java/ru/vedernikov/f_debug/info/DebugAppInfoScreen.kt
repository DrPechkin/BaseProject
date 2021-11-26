package ru.vedernikov.f_debug.info

import android.os.Build
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.vedernikov.f_debug.BuildConfig
import ru.vedernikov.f_debug.R
import ru.vedernikov.f_debug.ui.theme.DebugMenuTheme

@Composable
fun DebugAppInfoScreen() {
    val context = LocalContext.current
    val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
    val versionCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        packageInfo.longVersionCode
    } else {
        packageInfo.versionCode
    }
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = stringResource(
                id = R.string.debug_app_info_version_code_text,
                versionCode
            )
        )
        Text(text = stringResource(id = R.string.debug_app_info_version_name_text, packageInfo.versionName))
        Text(text = stringResource(id = R.string.debug_app_info_package_name_text, packageInfo.packageName))
        Text(text = stringResource(id = R.string.debug_app_info_build_type_text, BuildConfig.BUILD_TYPE))
    }
}

@Preview(showBackground = true)
@Composable
private fun DebugAppInfoScreenPreview() {
    DebugMenuTheme {
        DebugAppInfoScreen()
    }
}