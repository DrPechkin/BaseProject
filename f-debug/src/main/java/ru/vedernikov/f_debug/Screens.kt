package ru.vedernikov.f_debug

sealed class Screens(val route: String) {
    object Debug : Screens("debug")
    object AppInfo : Screens("appInfo")
    object Fcm : Screens("fcm")
    object ServerSettings: Screens("serverSettings")
}