package com.wesoft.featuredemo.space.di

import com.wesoft.featuredemo.di.scope.PerActivity
import com.wesoft.featuredemo.space.SpaceActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SpaceModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun spaceActivity(): SpaceActivity
}