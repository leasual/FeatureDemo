package com.wesoft.featuredemo

import com.wesoft.featuredemo.base.BaseNoViewModelActivity
import com.wesoft.featuredemo.scene.R
import com.wesoft.featuredemo.scene.databinding.ActivitySceneBinding

class SceneActivity : BaseNoViewModelActivity<ActivitySceneBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_scene

    override fun setupViews() {

    }
}
