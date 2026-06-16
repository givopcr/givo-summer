package com.example.givo_summer.pertemuan_11.data.api

import com.example.givo_summer.pertemuan_11.data.model.BeritaModel
import retrofit2.http.GET

interface BeritaApiService {
    @GET("posts")
    suspend fun getBerita(): List<BeritaModel>
}