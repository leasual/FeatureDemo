package com.wesoft.featuredemo

import com.wesoft.featuredemo.base.BaseNoViewModelActivity
import com.wesoft.featuredemo.profile.R
import com.wesoft.featuredemo.profile.databinding.ActivityProfileBinding

class ProfileActivity : BaseNoViewModelActivity<ActivityProfileBinding>() {

    override fun getLayoutId(): Int  = R.layout.activity_profile

    override fun setupViews() {

    }
}
