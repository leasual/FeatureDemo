package com.wesoft.featuredemo.di.module

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.wesoft.featuredemo.App
import com.wesoft.featuredemo.extension.PreferencesUtil
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by james.li on 2017/bg/20.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideSharePreferences(app: App): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(app)

    @Provides
    @Singleton
    fun provideSharePreferencesUtil(app: App): PreferencesUtil = PreferencesUtil(app)
}