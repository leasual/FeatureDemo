package com.wesoft.featuredemo.space.di

import androidx.lifecycle.ViewModel
import com.wesoft.featuredemo.di.ViewModelKey
import com.wesoft.featuredemo.di.module.BaseViewModelModule
import com.wesoft.featuredemo.space.RoomViewModel
import com.wesoft.featuredemo.space.SpaceViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule : BaseViewModelModule() {

    @Binds
    @IntoMap
    @ViewModelKey(SpaceViewModel::class)
    abstract fun bindsSpaceViewModel(viewModel: SpaceViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RoomViewModel::class)
    abstract fun bindsRoomViewModel(viewModel: RoomViewModel): ViewModel
}