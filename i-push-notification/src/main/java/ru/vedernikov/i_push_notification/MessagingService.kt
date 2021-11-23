package ru.vedernikov.i_push_notification

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import timber.log.Timber
import javax.inject.Inject

/**
 * Сервис для обработки пришедших пуш-уведомлений от Firebase.
 *
 * Срабатывает только если приложение не в фоне.
 * Иначе при клике на пуш происходит открытие LAUNCHER активити
 */
class MessagingService : FirebaseMessagingService() {

    @Inject
    lateinit var fcmStorage: FcmStorage

    override fun onNewToken(newToken: String) {
        super.onNewToken(newToken)
        Timber.i("New Firebase token: $newToken")

        fcmStorage.fcmToken = newToken
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Timber.i(
            "New push-notification: " +
                    "title = [${remoteMessage.notification?.title}], " +
                    "body = [${remoteMessage.notification?.body}], " +
                    "data = [${remoteMessage.data}]"
        )

        //todo Handle push other service
    }
}