package ru.vedernikov.base.ext

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

/**
 * Функция для копирования текста из TextView в буфер обмена
 */
fun Context.copyTextToClipboard(text: String) {
    val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    clipboardManager.setPrimaryClip(ClipData.newPlainText(null, text))
}