package example

import com.example.financas.data.FinancaDao
import com.example.financas.data.Financa
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.assertEquals

class FinancaDaoTest {

    private val dao = mockk<FinancaDao>(relaxed = true)

    @Test
    fun teste() = runTest {
        // Dado
        val financa = Financa(nome = "Aluguel", valor = 1000.0, data = "18/04/2025", recorrente = true)
        val listaMockada = listOf(financa)

        // Quando o método listarTodas for chamado, retorna a lista
        coEvery { dao.listarTodas() } returns listaMockada

        // Quando o método inserir for chamado, não faz nada (relaxed = true já cuida disso)

        // Ação
        dao.inserir(financa)
        val resultado = dao.listarTodas()

        // Verificação
        coVerify { dao.inserir(financa) }
        assertEquals(1, resultado.size)
        assertEquals("Aluguel", resultado[0].nome)
    }
}
