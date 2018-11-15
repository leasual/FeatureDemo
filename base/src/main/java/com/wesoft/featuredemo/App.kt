package com.wesoft.featuredemo

import android.app.Activity
import android.app.Application
import android.content.Context
import com.wesoft.featuredemo.di.component.AppComponent
import com.wesoft.featuredemo.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    lateinit var appComponent: AppComponent
    companion object {
        fun appComponent(context: Context) = (context.applicationContext as App).appComponent
    }

    //inject activity start
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
    }
}