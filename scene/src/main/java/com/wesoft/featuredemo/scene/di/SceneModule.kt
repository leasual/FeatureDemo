package com.wesoft.featuredemo.scene.di

import com.wesoft.featuredemo.di.scope.PerActivity
import com.wesoft.featuredemo.scene.SceneActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SceneModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun sceneActivity(): SceneActivity
}