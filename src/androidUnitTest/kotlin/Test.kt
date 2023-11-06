import android.content.Context
import junit.framework.TestCase.assertEquals
import lib.kotleni.credentials.AndroidEncryptedPrefsCredentials
import lib.kotleni.credentials.CredentialsStorage
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class Test {
    var appContext: Context? = null

    @Before
    fun setUp() {
        val app = RuntimeEnvironment.application
        appContext = app.applicationContext
    }

    @Test
    fun testCredentialsSetAndGet() {
        val credentialsStorage: CredentialsStorage = AndroidEncryptedPrefsCredentials(appContext!!)

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