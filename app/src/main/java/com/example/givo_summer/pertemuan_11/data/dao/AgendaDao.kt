package com.example.givo_summer.pertemuan_11.data.dao

import androidx.room.*
import com.example.givo_summer.pertemuan_11.data.entity.AgendaEntity

@Dao
interface AgendaDao {
    @Query("SELECT * FROM agenda")
    suspend fun getAllAgenda(): List<AgendaEntity>

    @Insert
    suspend fun insertAgenda(agenda: AgendaEntity)

    @Delete
    suspend fun deleteAgenda(agenda: AgendaEntity)
}