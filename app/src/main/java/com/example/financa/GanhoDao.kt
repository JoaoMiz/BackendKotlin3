package com.example.financa.data.dao

import androidx.room.*
import com.example.financa.data.entities.Ganho
import kotlinx.coroutines.flow.Flow

@Dao
interface GanhoDao {
    @Insert
    suspend fun insert(ganho: Ganho)

    @Query("SELECT * FROM ganhos")
    suspend fun getAll(): List<Ganho>

    @Query("SELECT * FROM ganhos WHERE nome = :nome LIMIT 1")
    suspend fun findByNome(nome: String): Ganho?

    @Update
    suspend fun update(ganho: Ganho)

    @Query("DELETE FROM ganhos WHERE nome = :nome")
    suspend fun deleteByNome(nome: String)
}
