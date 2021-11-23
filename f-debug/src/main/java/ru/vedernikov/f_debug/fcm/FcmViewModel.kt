package ru.vedernikov.f_debug.fcm

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class FcmViewModel @Inject constructor() : ViewModel() {


    private val _token: StateFlow<String> = MutableStateFlow("")
    val token: StateFlow<String>
        get() = _token


    fun loadFcmToken() {

    }
}