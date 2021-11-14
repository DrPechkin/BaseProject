package ru.vedernikov.f_debug.fcm

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import ru.vedernikov.base.ext.copyTextToClipboard
import ru.vedernikov.f_debug.R
import ru.vedernikov.f_debug.ui.theme.DebugMenuTheme

@Composable
fun FcmScreen(
    fcmViewModel: FcmViewModel = FcmViewModel()
) {
    val context = LocalContext.current
    val token by fcmViewModel.token.collectAsState()

    if (token.isEmpty()) {
        FcmEmpty {
            fcmViewModel.loadFcmToken()
        }
    } else {
        FcmRow(token = token) {
            context.copyTextToClipboard(it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FcmScreenPreview() {
    val isEmpty = true

    val token = if (isEmpty) {
        ""
    } else {
        "fWjyjSftScy46vcMoQQhtK:APA91bGVnGxeKU6fUhm0ulURoAlu3sOFexE-K1GqMBfXQkbbTa9U9d_CeTPqNvYdUegIUd4_mvDHIzjeaawEuu"
    }
    DebugMenuTheme {
        if (token.isEmpty()) {
            FcmEmpty {}
        } else {
            FcmRow(token = token) {}
        }
    }
}

@Composable
fun FcmEmpty(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = modifier.fillMaxWidth(),
            text = stringResource(id = R.string.debug_fcm_empty_text),
            textAlign = TextAlign.Center
        )
        TextButton(
            onClick = onClick,
            modifier = modifier
                .padding(16.dp)
        ) {
            Text(text = stringResource(id = R.string.debug_reload_btn_text))
        }
    }
}

@Composable
fun FcmRow(
    token: String,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .clickable { onClick(token) }
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Text(
                modifier = modifier
                    .wrapContentHeight()
                    .weight(3f),
                text = token
            )
            Image(
                modifier = modifier.weight(1f),
                painter = painterResource(id = R.drawable.debug_ic_copy_fcm_token),
                contentDescription = null
            )
        }
    }
}