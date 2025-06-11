package com.example.financa.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ganhos")
data class Ganho(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val valor: Double,
    val data: String,
    val recorrente: Boolean
)
