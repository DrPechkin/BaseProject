package ru.vedernikov.f_debug.server_settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.vedernikov.f_debug.DebugInteractor
import ru.vedernikov.f_debug.server_settings.reboot.DebugLauncherActivityRoute
import ru.vedernikov.i_network.type.ServerType
import javax.inject.Inject
import kotlin.math.log2

@HiltViewModel
class ServerSettingsDebugViewModel @Inject constructor(
    private val debugInteractor: DebugInteractor
) : ViewModel() {

    private val _state: MutableStateFlow<ServerSettingsDebugScreenModel> = MutableStateFlow(
        ServerSettingsDebugScreenModel(
            debugInteractor.serverType,
            millisecondsToSeconds(debugInteractor.requestDelay),
            delayMillisecondsToCoefficient(debugInteractor.requestDelay)
        )
    )
    val state: StateFlow<ServerSettingsDebugScreenModel>
        get() = _state


    fun setServerType(serverType: ServerType) {
        viewModelScope.launch {
            debugInteractor.serverType = serverType
            delay(1000)
            debugInteractor.reboot(DebugLauncherActivityRoute())
        }
    }

    fun requestDelayCoefficientChanges(coefficient: Int) {
        viewModelScope.launch {
            val requestDelayMilliseconds = delayCoefficientToMilliseconds(coefficient)
            debugInteractor.requestDelay = requestDelayMilliseconds
            _state.value = state.value.copy(
                requestDelayCoefficient = coefficient,
                requestDelaySeconds = millisecondsToSeconds(requestDelayMilliseconds)
            )
        }
    }

    private fun millisecondsToSeconds(milliseconds: Long): Float {
        return milliseconds / 1000.0F
    }

    private fun delayMillisecondsToCoefficient(delay: Long): Int {
        return if (delay == 0L) 0 else log2(delay / 500.0).toInt() + 1
    }

    private fun delayCoefficientToMilliseconds(coefficient: Int): Long {
        return if (coefficient == 0) 0 else (1L shl (coefficient - 1)) * 500L
    }
}

data class ServerSettingsDebugScreenModel(
    var serverType: ServerType,
    var requestDelaySeconds: Float,
    var requestDelayCoefficient: Int
)