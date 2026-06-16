package com.example.givo_summer.pertemuan_11.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.givo_summer.pertemuan_11.data.dao.AgendaDao
import com.example.givo_summer.pertemuan_11.data.dao.AspirasiDao
import com.example.givo_summer.pertemuan_11.data.entity.AgendaEntity
import com.example.givo_summer.pertemuan_11.data.entity.AspirasiEntity

@Database(entities = [AspirasiEntity::class, AgendaEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun aspirasiDao(): AspirasiDao
    abstract fun agendaDao(): AgendaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "binadesa_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}