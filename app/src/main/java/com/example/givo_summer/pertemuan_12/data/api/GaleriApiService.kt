package com.example.givo_summer.pertemuan_12.data.api

import com.example.givo_summer.pertemuan_12.data.model.GaleriModel
import retrofit2.http.GET

interface GaleriApiService {
    @GET("list")
    suspend fun getGaleri(): List<GaleriModel>
}