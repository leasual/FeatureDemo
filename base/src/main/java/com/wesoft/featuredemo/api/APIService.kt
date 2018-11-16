package com.wesoft.featuredemo.api

import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Created by james.li on 2018/8/21.
 */

interface APIService {

    @GET("today")
    fun getTodayList(): Flowable<String>
}