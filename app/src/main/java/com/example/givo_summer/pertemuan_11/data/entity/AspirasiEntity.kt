package com.example.givo_summer.pertemuan_11.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "aspirasi")
data class AspirasiEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val judul: String,
    val isi: String,
    val createdAt: Long
)