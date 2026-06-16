package com.example.givo_summer.pertemuan_11.data.api

import com.example.givo_summer.pertemuan_11.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}