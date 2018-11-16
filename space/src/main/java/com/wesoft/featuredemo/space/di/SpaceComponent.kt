package com.wesoft.featuredemo.space.di

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
            SpaceModule::class,
            ViewModelModule::class
        ])
interface SpaceComponent : AndroidInjector<SpaceModuleInjector>, DaggerComponent {
}