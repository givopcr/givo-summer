package com.example.givo_summer.pertemuan_11.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "agenda")
data class AgendaEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val judul: String,
    val lokasi: String,
    val waktu: String,
    val deskripsi: String
)