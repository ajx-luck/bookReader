package com.hemm.bookreader

import com.squareup.okhttp.OkHttpClient

/**
 * Created by B04e on 2017/5/22.
 */

object OkClient{
    private val client = OkHttpClient()
    fun instance() = client
}
