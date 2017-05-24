package com.hemm.bookreader

import android.os.Environment
import com.hemm.bookreader.utils.EncodeUtils
import com.squareup.okhttp.Headers
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response
import java.io.*

/**
 * Created by B04e on 2017/5/22.
 */

fun getHtml(url:String) :String{
    val client = OkClient.instance()
    val heads = Headers.Builder()
    heads.add("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36")
    heads.add("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
    heads.add("Accept-Encoding","None")
    heads.add("Accept-Language","zh-CN,zh;q=0.8")
    heads.add("Accept-Charset:utf-8")
    val request = Request.Builder().url(url).
            headers(heads.build()).build()

    val response = client.newCall(request).execute()

    val file = File(Environment.getExternalStorageDirectory(),"123.html");
    file.createNewFile();
    val body :String = response.body().string()
    file.writeText(body)
    return body
}
