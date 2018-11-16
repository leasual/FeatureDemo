package com.wesoft.featuredemo.space

import com.wesoft.featuredemo.ActivityLaunchHelper
import com.wesoft.featuredemo.base.BaseActivity
import com.wesoft.featuredemo.extension.toast
import com.wesoft.featuredemo.space.databinding.ActivitySpaceBinding
import com.wesoft.featuredemo.space.di.SpaceModuleInjector

class SpaceActivity : BaseActivity<SpaceViewModel, ActivitySpaceBinding>() {


    override fun getLayoutId(): Int = R.layout.activity_space

    override fun setupViews() {

        mBinding.btnStartToScene.setOnClickListener {
            toast(viewModel.testViewModel())
            ActivityLaunchHelper.launchScene(this, "space")
        }
    }

    override fun androidInject() {
        SpaceModuleInjector.inject(this)
    }
}
