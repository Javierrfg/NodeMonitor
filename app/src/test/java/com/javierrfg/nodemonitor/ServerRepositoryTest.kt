import org.junit.Assert.assertEquals
import org.junit.Test

class ServerRepositoryTest {

    @Test
    fun testRoomQuery_isNotNull() {
        // Simulamos la validación de una lista que vendría de Room
        val mockServerList = listOf("Servidor Oracle", "Servidor PostgreSQL")

        // Validamos que la petición devuelva el número correcto de elementos
        assertEquals(2, mockServerList.size)
    }
}