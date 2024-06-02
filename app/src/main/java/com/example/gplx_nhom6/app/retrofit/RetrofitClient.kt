package com.example.gplx_nhom6.app.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    fun getRetrofitClient(): ApiInterface {
        return Retrofit.Builder().baseUrl("http://192.168.1.20/Nhom6_Api/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiInterface::class.java)
    }
}