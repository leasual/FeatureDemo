package com.wesoft.featuredemo.profile.di

import com.wesoft.featuredemo.di.BaseModuleInjector
import com.wesoft.featuredemo.di.component.AppComponent
import com.wesoft.featuredemo.di.component.DaggerComponent
import dagger.android.AndroidInjector

object ProfileModuleInjector : BaseModuleInjector(){
    override fun moduleInjector(daggerComponent: DaggerComponent): AndroidInjector<out BaseModuleInjector> {
        return DaggerProfileComponent.builder()
                .appComponent(daggerComponent as AppComponent)
                .build()
    }
}