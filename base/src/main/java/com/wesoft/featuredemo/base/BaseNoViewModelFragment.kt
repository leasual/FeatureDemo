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
import com.wesoft.featuredemo.extension.PreferencesUtil
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * Created by james.li on 2017/7/27.
 */
abstract class BaseNoViewModelFragment<B : ViewDataBinding> : Fragment() {

    lateinit var mBinding: B

    @Inject
    lateinit var mPreferences: PreferencesUtil

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        setupViews()
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

    abstract fun androidInject()
}