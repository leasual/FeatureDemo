package com.wesoft.featuredemo.di.component

import com.wesoft.featuredemo.App
import com.wesoft.featuredemo.api.APIService
import com.wesoft.featuredemo.extension.PreferencesUtil

//提供子module需要的实例，如果是提供的实例是带参数的，需要在AppModule中提供带参的实例如PreferencesUtil
interface AppComponentProviders {

    fun provideApiService(): APIService

    fun provideApp(): App

    fun provideSharedPreferences(): PreferencesUtil
}