package com.wesoft.featuredemo.scene

import com.wesoft.featuredemo.ActivityLaunchHelper
import com.wesoft.featuredemo.base.BaseNoViewModelActivity
import com.wesoft.featuredemo.scene.databinding.ActivitySceneBinding
import com.wesoft.featuredemo.scene.di.SceneModuleInjector

class SceneActivity : BaseNoViewModelActivity<ActivitySceneBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_scene

    override fun setupViews() {
        mBinding.startToProfile.setOnClickListener {
            ActivityLaunchHelper.launchProfile(this, "scene")
        }
    }

    override fun androidInject() {
        SceneModuleInjector.inject(this)
    }
}
