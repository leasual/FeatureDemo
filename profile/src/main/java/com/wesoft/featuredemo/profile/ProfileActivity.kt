package com.wesoft.featuredemo.profile

import com.wesoft.featuredemo.ActivityLaunchHelper
import com.wesoft.featuredemo.base.BaseNoViewModelActivity
import com.wesoft.featuredemo.profile.databinding.ActivityProfileBinding
import com.wesoft.featuredemo.profile.di.ProfileModuleInjector

class ProfileActivity : BaseNoViewModelActivity<ActivityProfileBinding>() {

    override fun getLayoutId(): Int  = R.layout.activity_profile

    override fun setupViews() {
        mBinding.btnStartToEdit.setOnClickListener {
            ActivityLaunchHelper.launchEditProfile(this, "profile")
        }
    }

    override fun androidInject() {
        ProfileModuleInjector.inject(this)
    }
}
