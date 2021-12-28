package ru.vedernikov.app.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.vedernikov.base.NO_BACKUP_SHARED_PREF
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Named(NO_BACKUP_SHARED_PREF)
    fun provideSharedPref(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(NO_BACKUP_SHARED_PREF, Context.MODE_PRIVATE)
    }
}