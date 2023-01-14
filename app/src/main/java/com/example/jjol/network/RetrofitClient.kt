package com.example.jjol.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {
    private val baseURI = "http://172.20.67.156:5436/"

    val retrofit = Retrofit.Builder()
        .baseUrl(baseURI)
        .client(okHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUser(): UserAPI {
        return retrofit.create(UserAPI::class.java)
    }
}

private fun okHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val authorizationInterceptor = AuthorizationInterceptor()

    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(authorizationInterceptor)
        .build()
}