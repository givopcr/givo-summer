package com.example.givo_summer.pertemuan_11.data.api

import com.example.givo_summer.pertemuan_11.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}