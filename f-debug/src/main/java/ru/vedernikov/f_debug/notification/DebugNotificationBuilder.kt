package ru.vedernikov.f_debug.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import androidx.core.app.NotificationCompat
import ru.vedernikov.base.SdkUtils
import ru.vedernikov.f_debug.R
import ru.vedernikov.f_debug.debug.DebugActivityView

private val DEBUG_NOTIFICATION_ID = "DEBUG_NOTIFICATION_ID".hashCode()

/**
 * Показывает нотификацию экрана отладки
 * При нажатии нотификации откроется [DebugActivityView]
 */
object DebugNotificationBuilder {

    fun showDebugNotification(context: Context, icon: Int) {
        val channelId = context.getString(R.string.debug_notification_channel_id)
        val notificationTitle = context.getString(R.string.debug_screen_title)
        val notificationBody = context.getString(R.string.debug_screen_body)

        val pendingIntent = PendingIntent.getActivity(
            context,
            DEBUG_NOTIFICATION_ID,
            DebugActivityView.prepareIntent(context),
            PendingIntent.FLAG_UPDATE_CURRENT)

        val notificationBuilder = NotificationCompat.Builder(context, channelId)
            .setContentTitle(notificationTitle)
            .setContentIntent(pendingIntent)
            .setOngoing(true)

        if(SdkUtils.isAtLeastLollipop()){
            notificationBuilder.setSmallIcon(R.drawable.debug_ic_debug)
        } else {
            notificationBuilder.setSmallIcon(icon)
        }

        if (!SdkUtils.isAtLeastNougat()) {
            notificationBuilder.setContentText("App")
        }

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        SdkUtils.runOnOreo {
            notificationManager.createNotificationChannel(
                NotificationChannel(
                    channelId,
                    notificationTitle,
                    NotificationManager.IMPORTANCE_HIGH).apply {
                    description = notificationBody
                }
            )
        }

        notificationManager.notify(DEBUG_NOTIFICATION_ID, notificationBuilder.build())
    }
}