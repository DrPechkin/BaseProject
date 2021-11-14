package ru.vedernikov.f_debug.fcm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FcmViewModel : ViewModel() {


    private val _token: StateFlow<String> = MutableStateFlow("")
    val token: StateFlow<String>
        get() = _token


    fun loadFcmToken() {

    }
}