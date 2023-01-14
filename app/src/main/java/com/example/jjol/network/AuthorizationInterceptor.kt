package com.example.jjol.network

import android.util.Log
import com.example.jjol.Jjol
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val path = request.url.encodedPath
        val method = request.method

        val ignorePath = listOf(
            "/user/login",
            "/user/signup"
        )

        Log.d("TAG", "path: $path")
        return if (ignorePath.contains(path))
            chain.proceed(request)
        else
            chain.proceed(request.newBuilder().header("Authorization", Jjol.token).build())
    }
}