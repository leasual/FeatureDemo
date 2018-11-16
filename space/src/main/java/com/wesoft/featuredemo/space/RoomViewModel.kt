package com.wesoft.featuredemo.space

import com.wesoft.featuredemo.base.BaseViewModel
import javax.inject.Inject

class RoomViewModel @Inject constructor() : BaseViewModel<SpaceRepository>() {

    fun testViewModel(): String {
        //preferencesUtil.defaultPreferences.putString("test", "for test")
        return "viewModel get repository= ${repository.testRepository()}"
    }
}