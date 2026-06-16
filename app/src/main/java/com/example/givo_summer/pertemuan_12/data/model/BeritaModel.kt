package com.example.givo_summer.pertemuan_12.data.model

import com.google.gson.annotations.SerializedName

data class BeritaModel(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val judul: String,
    @SerializedName("body") val isi: String
)