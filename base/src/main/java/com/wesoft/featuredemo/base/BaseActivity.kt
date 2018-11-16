package com.wesoft.featuredemo.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.wesoft.wehome.vo.ViewModelTypeResolver
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by james.li on 2017/07/20.
 */
abstract class BaseActivity<VM : BaseViewModel<*>, B : ViewDataBinding> : AppCompatActivity(), HasSupportFragmentInjector {
    private val TAG = "BaseActivity"

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var viewModel: VM

    lateinit var mBinding: B

    // support fragment injection-----start
    override fun supportFragmentInjector() = dispatchingAndroidInjector

    @Inject
    protected lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    // support fragment injection-----end


    override fun onCreate(savedInstanceState: Bundle?) {
        androidInject()
        super.onCreate(savedInstanceState)
        val viewModelType = ViewModelTypeResolver.findViewModelType<BaseViewModel<*>>(javaClass)
        if (viewModelType != null) {
            @Suppress("UNCHECKED_CAST")
            viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelType) as VM
        }
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
