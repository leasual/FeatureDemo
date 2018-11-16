package com.wesoft.featuredemo.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.wesoft.featuredemo.extension.PreferencesUtil
import com.wesoft.wehome.vo.ViewModelTypeResolver
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Created by james.li on 2017/7/27.
 */
abstract class BaseFragment<VM : BaseViewModel<*>, B : ViewDataBinding> : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: VM

    lateinit var mBinding: B

    @Inject
    lateinit var mPreferences: PreferencesUtil

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        val viewModelType = ViewModelTypeResolver.findViewModelType<BaseViewModel<*>>(javaClass)
        if (viewModelType != null) {
            @Suppress("UNCHECKED_CAST")
            viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelType) as VM
        }
        observeData()
        setupViews()
        viewModel.isLoading.observe(this, Observer { isLoading ->

        })
        return mBinding.root
    }

    // support fragment injection
    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        androidInject()
        super.onAttach(context)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun setupViews()

    abstract fun observeData()

    abstract fun androidInject()
}