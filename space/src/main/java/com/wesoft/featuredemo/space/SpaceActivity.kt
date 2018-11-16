package com.wesoft.featuredemo.space

import com.wesoft.featuredemo.base.BaseActivity
import com.wesoft.featuredemo.space.databinding.ActivitySpaceBinding
import com.wesoft.featuredemo.space.di.SpaceModuleInjector

class SpaceActivity : BaseActivity<SpaceViewModel, ActivitySpaceBinding>() {


    override fun getLayoutId(): Int = R.layout.activity_space

    override fun setupViews() {

        supportFragmentManager.beginTransaction()
                .replace(R.id.fl_container, RoomFragment.newInstance())
                .commit()
    }

    override fun androidInject() {
        SpaceModuleInjector.inject(this)
    }
}
