package com.example.financa.data

import com.example.financa.data.dao.GanhoDao
import com.example.financa.data.entities.Ganho
import kotlinx.coroutines.flow.Flow

class GanhoRepository(private val dao: GanhoDao) {

    suspend fun inserir(ganho: Ganho) {
        dao.insert(ganho)
    }

    suspend fun listar(): List<Ganho> {
        return dao.getAll()
    }

    suspend fun deletarPorNome(nome: String) {
        dao.deleteByNome(nome)
    }

    suspend fun atualizarPorNome(
        nome: String,
        novoValor: Double,
        novaData: String,
        novoRecorrente: Boolean
    ) {
        val ganho = dao.findByNome(nome)
        if (ganho != null) {
            val atualizado = ganho.copy(
                valor = novoValor,
                data = novaData,
                recorrente = novoRecorrente
            )
            dao.update(atualizado)
        }
    }
}