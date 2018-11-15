package com.wesoft.featuredemo.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject

/**
 * Created by james.li on 2017/07/20.
 */
abstract class BaseNoViewModelActivity<B : ViewDataBinding> : AppCompatActivity(), HasFragmentInjector {
    private val TAG = "BaseActivity"

    lateinit var mBinding: B

    // support fragment injection-----start
    override fun fragmentInjector() = dispatchingAndroidInjector

    @Inject
    protected lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<android.app.Fragment>
    // support fragment injection-----end


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
    }


    override fun onDestroy() {
        mBinding.let {
            mBinding.unbind()
        }
        super.onDestroy()
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun setupViews()
}
