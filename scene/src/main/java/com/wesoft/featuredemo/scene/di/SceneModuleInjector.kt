package com.wesoft.featuredemo.scene.di

import com.wesoft.featuredemo.di.BaseModuleInjector
import com.wesoft.featuredemo.di.component.AppComponent
import com.wesoft.featuredemo.di.component.DaggerComponent
import dagger.android.AndroidInjector

object SceneModuleInjector : BaseModuleInjector(){
    override fun moduleInjector(daggerComponent: DaggerComponent): AndroidInjector<out BaseModuleInjector> {
        return DaggerSceneComponent.builder()
                .appComponent(daggerComponent as AppComponent)
                .build()
    }
}