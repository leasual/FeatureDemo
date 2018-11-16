package com.wesoft.featuredemo.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by james.li on 2017/07/20.
 */
abstract class BaseNoViewModelActivity<B : ViewDataBinding> : AppCompatActivity(), HasSupportFragmentInjector {
    private val TAG = "BaseActivity"

    lateinit var mBinding: B

    // support fragment injection-----start
    override fun supportFragmentInjector() = dispatchingAndroidInjector

    @Inject
    protected lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    // support fragment injection-----end


    override fun onCreate(savedInstanceState: Bundle?) {
        //AndroidInjection.inject(this)
        androidInject()
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        setupViews()
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

    abstract fun androidInject()
}
