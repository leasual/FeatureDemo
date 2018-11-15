package com.wesoft.featuredemo.base

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by james.li on 2017/7/26.
 */
abstract class BaseViewModel<R : BaseRepository> : ViewModel() {

    val dispose: CompositeDisposable = CompositeDisposable()

    var isLoading = MediatorLiveData<Boolean>()

    @Inject
    lateinit var repository: R


    override fun onCleared() {
        super.onCleared()
        if (!dispose.isDisposed) {
            dispose.dispose()
            dispose.clear()
        }
    }
}