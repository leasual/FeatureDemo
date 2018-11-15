package com.wesoft.featuredemo.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.wesoft.wehome.vo.ViewModelTypeResolver
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject

/**
 * Created by james.li on 2017/07/20.
 */
abstract class BaseActivity<VM : BaseViewModel<*>, B : ViewDataBinding> : AppCompatActivity(), HasFragmentInjector {
    private val TAG = "BaseActivity"

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM

    lateinit var mBinding: B

    // support fragment injection-----start
    override fun fragmentInjector() = dispatchingAndroidInjector

    @Inject
    protected lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<android.app.Fragment>
    // support fragment injection-----end


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val viewModelType = ViewModelTypeResolver.findViewModelType<BaseViewModel<*>>(javaClass)
        if (viewModelType != null) {
            @Suppress("UNCHECKED_CAST")
            viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelType) as VM
        }
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())

        viewModel.isLoading.observe(this, Observer { isLoading ->

        })

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

    abstract fun observeData()
}
