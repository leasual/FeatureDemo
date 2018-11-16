package com.wesoft.featuredemo.space

import android.util.Log
import com.wesoft.featuredemo.base.BaseRepository
import com.wesoft.featuredemo.extension.ioMain
import javax.inject.Inject

class SpaceRepository @Inject constructor() : BaseRepository() {

    fun testRepository(): String {
        Log.d("test", "apiService= ${apiService.javaClass.simpleName}")
        apiService.getTodayList()
                .ioMain()
                .subscribe(
                        {
                            Log.d("test", "response= $it")
                        },
                        {
                            Log.e("test", "error= ${it.printStackTrace()}")
                        }
                )
        return "space repository"
    }
}