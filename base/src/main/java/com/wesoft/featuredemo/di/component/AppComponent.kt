package com.wesoft.featuredemo.di.component

import com.wesoft.featuredemo.App
import com.wesoft.featuredemo.di.module.AppModule
import com.wesoft.featuredemo.di.module.BaseViewModelModule
import com.wesoft.featuredemo.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    NetworkModule::class,
    BaseViewModelModule::class
])

interface AppComponent : AndroidInjector<App>, DaggerComponent, AppComponentProviders{

    override fun inject(instance: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}