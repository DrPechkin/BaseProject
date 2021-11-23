package ru.vedernikov.f_debug.server_settings

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.vedernikov.f_debug.R
import ru.vedernikov.f_debug.ui.theme.DebugMenuTheme
import ru.vedernikov.i_network.type.ServerType

@Composable
fun ServerSettingsDebugScreen(
    viewModel: ServerSettingsDebugViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        ServerTypeRadioGroup(
            Modifier.padding(horizontal = 16.dp),
            selectedServerType = state.value.serverType
        ) {
            viewModel.setServerType(ServerType.valueOf(it))
        }

        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp),
            text = stringResource(
                id = R.string.debug_server_settings_request_delay_text,
                state.value.requestDelaySeconds
            )
        )
        Slider(
            modifier = Modifier.padding(horizontal = 16.dp),
            value = state.value.requestDelayCoefficient.toFloat(),
            valueRange = 0f..5f,
            onValueChange = { viewModel.requestDelayCoefficientChanges(it.toInt()) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ServerSettingsDebugScreenPreview() {
    DebugMenuTheme {
        ServerSettingsDebugScreen()
    }
}

@Composable
fun ServerTypeRadioGroup(
    modifier: Modifier,
    selectedServerType: ServerType,
    onSelectedChange: (String) -> Unit
) {

    val radioGroupOptions: List<String> = ServerType.values().map { it.name }

    var selected by remember { mutableStateOf(selectedServerType.name) }

    Column(
        modifier = modifier.padding(top = 8.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = stringResource(
                id = R.string.debug_server_settings_choose_server_type_tv
            ),
            style = MaterialTheme.typography.h6
        )

        radioGroupOptions.forEach { text ->
            Row(Modifier
                .fillMaxWidth()
                .selectable(
                    selected = text == selected,
                    onClick = {
                        selected = text
                        onSelectedChange(text)
                    }
                )
                .padding(vertical = 8.dp)
            ) {
                RadioButton(
                    selected = text == selected,
                    onClick = {
                        selected = text
                        onSelectedChange(text)
                    }
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}