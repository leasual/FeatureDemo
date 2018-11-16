package com.wesoft.featuredemo.space

import com.wesoft.featuredemo.base.BaseViewModel
import com.wesoft.featuredemo.extension.PreferencesUtil
import com.wesoft.featuredemo.extension.putString
import javax.inject.Inject

class SpaceViewModel @Inject constructor() : BaseViewModel<SpaceRepository>() {

    @Inject
    lateinit var preferencesUtil: PreferencesUtil

    fun testViewModel(): String {
        preferencesUtil.defaultPreferences.putString("test", "for test")
        return "viewModel get repository= ${repository.testRepository()}"
    }
}