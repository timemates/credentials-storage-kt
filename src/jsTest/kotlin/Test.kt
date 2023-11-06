import lib.kotleni.credentials.CredentialsStorage
import lib.kotleni.credentials.CredentialsStorageImpl
import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val credentialsStorage: CredentialsStorage = CredentialsStorageImpl()

    @Test
    fun testCredentialsSetAndGet() {
        val string = "hi"
        val int = 1
        val long = 1L
        val boolean = false

        // Init
        credentialsStorage.initialize()

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