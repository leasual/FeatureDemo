package com.wesoft.featuredemo.space.di

import com.wesoft.featuredemo.di.BaseModuleInjector
import com.wesoft.featuredemo.di.component.AppComponent
import com.wesoft.featuredemo.di.component.DaggerComponent
import dagger.android.AndroidInjector

object SpaceModuleInjector : BaseModuleInjector(){
    override fun moduleInjector(daggerComponent: DaggerComponent): AndroidInjector<out BaseModuleInjector> {
        return DaggerSpaceComponent.builder()
                .appComponent(daggerComponent as AppComponent)
                .build()
    }
}