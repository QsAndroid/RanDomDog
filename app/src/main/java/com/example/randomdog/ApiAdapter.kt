package com.example.randomdog

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiAdapter {

    val apiClient : ApiClient = Retrofit.Builder()
        .baseUrl("https://dog.ceo")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiClient::class.java)

}