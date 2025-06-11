package com.example.financas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.financa.data.dao.GanhoDao
import com.example.financa.data.entities.Ganho

@Database(entities = [Financa::class, Ganho::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun financaDao(): FinancaDao
    abstract fun ganhoDao(): GanhoDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "financas_db"
                ).fallbackToDestructiveMigration()
                 .build().also { INSTANCE = it }
            }
        }
    }
}
