package com.wesoft.featuredemo.scene.di

import com.wesoft.featuredemo.di.component.AppComponent
import com.wesoft.featuredemo.di.component.DaggerComponent
import com.wesoft.featuredemo.di.scope.PerModuleScope
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerModuleScope
@Component(dependencies = [AppComponent::class],
        modules = [
            AndroidSupportInjectionModule::class,
            SceneModule::class
        ])
interface SceneComponent : AndroidInjector<SceneModuleInjector>, DaggerComponent {
}