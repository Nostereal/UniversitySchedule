package com.nostereal.universityschedule.utils.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.util.TypedValue

val Context.isNetworkAvailable: Boolean
    get() {
        val connectivityManager: ConnectivityManager? =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager

        val isOnline = connectivityManager?.activeNetworkInfo?.isConnected
        return isOnline ?: false
    }

fun Context.convertDpToPx(dp: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        this.resources.displayMetrics
    )
}