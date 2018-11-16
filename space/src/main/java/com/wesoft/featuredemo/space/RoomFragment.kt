package com.wesoft.featuredemo.space


import com.wesoft.featuredemo.ActivityLaunchHelper
import com.wesoft.featuredemo.base.BaseFragment
import com.wesoft.featuredemo.extension.toast
import com.wesoft.featuredemo.space.databinding.FragmentRoomBinding
import com.wesoft.featuredemo.space.di.SpaceModuleInjector

class RoomFragment : BaseFragment<RoomViewModel, FragmentRoomBinding>() {

    override fun getLayoutId(): Int = R.layout.fragment_room

    override fun setupViews() {
        mBinding.btnStartToScene.setOnClickListener {
            activity!!.toast(viewModel.testViewModel())
            ActivityLaunchHelper.launchScene(activity!!, "space")
        }
    }

    override fun androidInject() {
        SpaceModuleInjector.inject(activity!!)
    }

    override fun observeData() {

    }

    companion object {

        @JvmStatic
        fun newInstance() = RoomFragment().apply { }
    }
}
