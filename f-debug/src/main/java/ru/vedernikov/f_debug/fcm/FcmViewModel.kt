package ru.vedernikov.f_debug.fcm

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.vedernikov.i_push_notification.FcmStorage
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FcmViewModel @Inject constructor(
    private val fcmStorage: FcmStorage
) : ViewModel() {

    private val _token: MutableStateFlow<String> = MutableStateFlow(fcmStorage.fcmToken)
    val token: StateFlow<String>
        get() = _token

    fun loadFcmToken() {
        _token.value = fcmStorage.fcmToken
        logFcmToken()
    }

    private fun logFcmToken() {
        token.value.apply {
            if (isNotEmpty()) {
                Timber.d("FCM-token: $this")
            }
        }
    }
}