package com.wesoft.featuredemo.model

import com.google.gson.annotations.SerializedName
import io.reactivex.Flowable

data class BaseResponse<T>(
        @SerializedName("Code") var code: Int,
        @SerializedName("Data") var data: T,
        @SerializedName("Message") var message: String,
        @SerializedName("RecordCount") var recordCount: Int,
        @SerializedName("PageSize") var pageSize: Int,
        @SerializedName("CurrentPageIndex") var currentPageIndex: Int,
        @SerializedName("SortNo") var sort: Int,
        @SerializedName("PageCount") var pageCount: Int
)

fun <T> BaseResponse<T>.filterData(): Flowable<BaseResponse<T>> {
    return if (code == 0 || code == 2331) {
        Flowable.just(this)
    } else {
        Flowable.error(Throwable("code"))
    }
}