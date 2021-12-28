package ru.vedernikov.i_push_notification

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.vedernikov.base.NO_BACKUP_SHARED_PREF
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object NotificationModule {

    @Provides
    fun provideFcmStorage(
        @Named(NO_BACKUP_SHARED_PREF) noBackupSharedPref: SharedPreferences
    ): FcmStorage {
        return FcmStorage(noBackupSharedPref)
    }
}