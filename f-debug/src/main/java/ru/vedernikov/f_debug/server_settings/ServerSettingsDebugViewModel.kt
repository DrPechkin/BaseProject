package ru.vedernikov.f_debug.server_settings

import androidx.lifecycle.ViewModel
import ru.vedernikov.f_debug.DebugInteractor
import ru.vedernikov.i_network.type.ServerType
import kotlin.math.log2

class ServerSettingsDebugViewModel(
    private val debugInteractor: DebugInteractor
) : ViewModel() {

    fun setServerType(serverType: ServerType) {
        debugInteractor.serverType = serverType
        // activityNavigator.start(RebootDebugActivityRoute())
        // activityNavigator.finishAffinity()
    }

    fun requestDelayCoefficientChanges(coefficient: Int) {
        val requestDelayMilliseconds = delayCoefficientToMilliseconds(coefficient)
        debugInteractor.requestDelay = requestDelayMilliseconds
//        sm.requestDelayCoefficient = coefficient
//        sm.requestDelaySeconds = millisecondsToSeconds(requestDelayMilliseconds)
//        view.render(sm)
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