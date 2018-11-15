package com.wesoft.featuredemo.base

import com.wesoft.featuredemo.api.APIService
import javax.inject.Inject

/**
 * Created by james on 2018/8/21.
 */

abstract class BaseRepository {

    @Inject
    lateinit var apiService: APIService


}