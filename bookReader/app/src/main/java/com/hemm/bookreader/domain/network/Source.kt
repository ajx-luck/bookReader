package com.hemm.bookreader.domain.network

/**
 * Created by B04e on 2017/5/22.
 */
interface Source<T> {
    fun obtain(url: String): T
}
