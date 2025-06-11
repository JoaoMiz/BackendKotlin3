package example

import com.example.financa.data.dao.GanhoDao
import com.example.financa.data.entities.Ganho
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.util.UUID

@OptIn(ExperimentalCoroutinesApi::class)
class GanhoDaoTest {

    private lateinit var ganhoDao: GanhoDao

    @Before
    fun setup() {
        ganhoDao = mockk()
    }

    @Test
    fun inserirEListarGanho() = runTest {
        val ganho = Ganho(
            nome = "Salário",
            valor = 2500.0,
            data = "20/05/2025",
            recorrente = false
        )

        coEvery { ganhoDao.insert(ganho) } returns Unit
        coEvery { ganhoDao.getAll() } returns listOf(ganho)

        ganhoDao.insert(ganho)
        val ganhos = ganhoDao.getAll()

        assert(ganhos.contains(ganho))
        coVerify { ganhoDao.insert(ganho) }
        coVerify { ganhoDao.getAll() }
    }
}
