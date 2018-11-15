package com.wesoft.featuredemo.vo

import android.annotation.SuppressLint
import android.util.Log
import com.wesoft.featuredemo.App
import com.wesoft.featuredemo.extension.RetryWithDelay
import com.wesoft.featuredemo.extension.ioMain
import com.wesoft.featuredemo.extension.isNetworkAvailable
import com.wesoft.featuredemo.extension.toast
import com.wesoft.featuredemo.model.BaseResponse
import com.wesoft.featuredemo.model.filterData
import com.wesoft.featuredemo.api.APIException
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.FlowableOnSubscribe
import io.reactivex.internal.operators.flowable.FlowableCreate
import retrofit2.HttpException
import timber.log.Timber

/**
 * Created by james on 2018/8/22.
 */

/**
 * 网络帮助类
 * @param ResultType 需要返回的数据类型
 * @param RequestType 网络请求回来的数据类型
 */
abstract class NetworkBoundResource<ResultType, RequestType>(val app: App) {

    private val flowableOnSubscribe: FlowableOnSubscribe<BaseResponse<ResultType>>

    init {

        //whether should fetch from network
        val networkState = app.applicationContext.isNetworkAvailable()
        @Suppress("LeakingThis")
        when (networkState) {
            true -> {
                flowableOnSubscribe = if (shouldLoadFromCache()) {
                    FlowableOnSubscribe { emitter ->
                        Log.d("test", "get data from cache")
                        val cacheData = loadFromDB()
                        cacheData?.let { emitter.onNext(BaseResponse(0, cacheData, "", 0, 0, 0, 0, 0)) }
                        if (shouldFetch(cacheData)) {
                            fetchFromNetwork(emitter)
                        } else {
                            emitter.onNext(BaseResponse(0, Any() as ResultType, "", 0, 0, 0, 0, 0))
                        }
                    }
                } else {
                    FlowableOnSubscribe { emitter ->
                        fetchFromNetwork(emitter)
                    }
                }
            }
            else -> {
                flowableOnSubscribe = if (shouldLoadFromCache()) {
                    FlowableOnSubscribe { emitter ->
                        val cacheData = loadFromDB()
                        cacheData?.let { emitter.onNext(BaseResponse(0, cacheData, "", 0, 0, 0, 0, 0)) }
                                ?: emitter.onNext(BaseResponse(0, Any() as ResultType, "", 0, 0, 0, 0, 0))
                    }
                } else {
                    FlowableOnSubscribe { emitter ->
                        emitter.onComplete()
                    }
                }
                app.applicationContext.toast("网络未连接，请检查网络再重试")
            }
        }
    }

    @SuppressLint("CheckResult")
    @Suppress("UNCHECKED_CAST")
    private fun fetchFromNetwork(emitter: FlowableEmitter<BaseResponse<ResultType>>) {
        callApi()
                .flatMap { (it as BaseResponse<ResultType>).filterData() }
                .retryWhen(RetryWithDelay(3))
                .ioMain()
                .subscribe(
                        { data ->
                            /**
                             *  这里请注意，Rxjava 2.x之后不支持发送null的数据，
                             *  所以当data.data也就是返回的数据为空时，需要判定，如果为空
                             *  这是我们需要给他赋予一个新的值，才能发送。并且需要在APIService中定义返回类型为Any
                             */
                            data.data?.let {
                                cache(data.data)
                                emitter.onNext(data)
                            }
                                    ?: emitter.onNext(BaseResponse(0, Any() as ResultType, "", 0, 0, 0, 0, 0))
                            Log.d("test", "get data from network")
                        },
                        { throwable ->
                            when (throwable) {
                                is HttpException -> {
                                    if (throwable.response().code() == 404) {
                                        app.applicationContext.toast("服务器地址不存在")
                                    } else {
                                        app.applicationContext.toast("网络不给力，请重试")
                                    }
                                }
                                is APIException -> {
                                    //app.applicationContext.toast(throwable.info)
                                }
                                else -> {
                                    Timber.d("throwable:"+throwable.message)
                                    app.applicationContext.toast("数据异常，请重试")
                                }
                            }
                            emitter.onError(throwable)
                        },
                        {
                            emitter.onComplete()
                        }
                )
    }

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun shouldLoadFromCache(): Boolean

    protected abstract fun loadFromDB(): ResultType?

    protected abstract fun cache(data: ResultType)

    protected abstract fun callApi(): Flowable<BaseResponse<RequestType>>

    fun asFlowable(): Flowable<BaseResponse<ResultType>> {
        return FlowableCreate(flowableOnSubscribe, BackpressureStrategy.LATEST)
                .ioMain()
    }
}