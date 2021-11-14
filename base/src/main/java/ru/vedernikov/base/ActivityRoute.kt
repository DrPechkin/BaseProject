package ru.vedernikov.base

import android.content.Context
import android.content.Intent

interface ActivityRoute {
    fun prepareIntent(context: Context): Intent
}