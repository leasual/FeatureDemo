package com.wesoft.featuredemo.di.module

import androidx.lifecycle.ViewModelProvider
import com.wesoft.featuredemo.di.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class BaseViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}