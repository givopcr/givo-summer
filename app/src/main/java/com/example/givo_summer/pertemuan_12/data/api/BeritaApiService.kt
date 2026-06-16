package com.example.givo_summer.pertemuan_12.data.api

import com.example.givo_summer.pertemuan_12.data.model.BeritaModel
import retrofit2.http.GET

interface BeritaApiService {
    @GET("posts")
    suspend fun getBerita(): List<BeritaModel>
}