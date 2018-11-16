package com.wesoft.featuredemo.space.di

import com.wesoft.featuredemo.space.RoomFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun roomFragment(): RoomFragment
}