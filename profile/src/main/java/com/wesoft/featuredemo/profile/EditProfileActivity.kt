package com.wesoft.featuredemo.profile

import com.wesoft.featuredemo.base.BaseNoViewModelActivity
import com.wesoft.featuredemo.profile.databinding.ActivityEditProfileBinding
import com.wesoft.featuredemo.profile.di.ProfileModuleInjector

class EditProfileActivity : BaseNoViewModelActivity<ActivityEditProfileBinding>() {

    override fun getLayoutId(): Int  = R.layout.activity_edit_profile

    override fun setupViews() {

    }

    override fun androidInject() {
        ProfileModuleInjector.inject(this)
    }
}
