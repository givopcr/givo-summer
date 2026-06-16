package com.example.givo_summer.pertemuan_11.data.model

import com.google.gson.annotations.SerializedName

data class GaleriModel(
    @SerializedName("id") val id: String,
    @SerializedName("author") val penulis: String,
    @SerializedName("download_url") val fotoUrl: String
)