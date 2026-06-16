package com.example.givo_summer.pertemuan_12.data.dao

import androidx.room.*
import com.example.givo_summer.pertemuan_12.data.entity.AspirasiEntity

@Dao
interface AspirasiDao {
    @Query("SELECT * FROM aspirasi ORDER BY createdAt DESC")
    suspend fun getAllAspirasi(): List<AspirasiEntity>

    @Insert
    suspend fun insertAspirasi(aspirasi: AspirasiEntity)

    @Delete
    suspend fun deleteAspirasi(aspirasi: AspirasiEntity)
}