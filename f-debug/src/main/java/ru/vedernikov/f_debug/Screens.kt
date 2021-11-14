package ru.vedernikov.f_debug

sealed class Screens(val route: String) {
    object Debug : Screens("debug")
    object Fcm : Screens("fcm")
}