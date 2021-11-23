package ru.vedernikov.f_debug.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

const val NO_BACKUP_SHARED_PREF = "NO_BACKUP_SHARED_PREF"

@Module
@InstallIn(SingletonComponent::class)
object DebugModule {

    @Provides
    fun provideSharedPref(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(NO_BACKUP_SHARED_PREF, Context.MODE_PRIVATE)
    }

//    @Provides
//    fun provideFcmStorage(
//        @Named(NO_BACKUP_SHARED_PREF) noBackupSharedPref: SharedPreferences
//    ): FcmStorage {
//        return FcmStorage(noBackupSharedPref)
//    }
}