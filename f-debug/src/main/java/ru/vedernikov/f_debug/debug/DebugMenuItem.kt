package ru.vedernikov.f_debug.debug

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.vedernikov.f_debug.ui.theme.DebugMenuTheme

@Composable
fun DebugMenuItem(
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Text(
        text = title,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DebugMenuItemPreview() {
    DebugMenuTheme {
        DebugMenuItem("Test") {

        }
    }
}