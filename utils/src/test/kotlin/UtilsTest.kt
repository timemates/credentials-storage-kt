import io.timemates.credentials.CredentialsStorage
import io.timemates.credentials.utils.InMemoryCredentialsStorage
import org.junit.Test
import kotlin.test.assertEquals

class UtilsTest {
    @Test
    fun testInMemoryCredentialsStorage() {
        val credentialsStorage: CredentialsStorage = InMemoryCredentialsStorage()

        val string = "hi"
        val int = 1
        val long = 1L
        val boolean = false

        // Store
        credentialsStorage.setString("string", string)
        credentialsStorage.setInt("int", int)
        credentialsStorage.setLong("long", long)
        credentialsStorage.setBoolean("boolean", boolean)

        // Get and check
        assertEquals(string, credentialsStorage.getString("string"))
        assertEquals(int, credentialsStorage.getInt("int"))
        assertEquals(long, credentialsStorage.getLong("long"))
        assertEquals(boolean, credentialsStorage.getBoolean("boolean"))
    }
}