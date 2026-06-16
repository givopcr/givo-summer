package com.example.givo_summer.pertemuan_12.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GaleriApiClient {
    private const val BASE_URL = "https://picsum.photos/v2/"

    val apiService: GaleriApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GaleriApiService::class.java)
    }
}