package com.wesoft.featuredemo.extension

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

/**
 * Created by james.li on 2017/bg/20.
 */

fun Context.isNetworkAvailable(): Boolean {
    val connectionManager = getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
    return connectionManager?.activeNetworkInfo?.isConnected ?: false
}

fun Context.toast(message: String, time: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, time).show()
}

fun Context.toast(message: Int, time: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, time).show()
}