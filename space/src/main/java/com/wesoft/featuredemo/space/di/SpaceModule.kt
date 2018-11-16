package com.wesoft.featuredemo.space.di

import com.wesoft.featuredemo.space.SpaceActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SpaceModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun spaceActivity(): SpaceActivity
}