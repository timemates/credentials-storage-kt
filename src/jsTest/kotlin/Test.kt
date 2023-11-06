import lib.kotleni.credentials.Credential
import lib.kotleni.credentials.CredentialsManager
import lib.kotleni.credentials.CredentialsManagerImpl
import kotlin.test.Test
import kotlin.test.assertEquals

class Test {
    private val credentialsManager: CredentialsManager = CredentialsManagerImpl()

    @Test
    fun testCredentialSetAndGet() {
        credentialsManager.initialize()

        val credential = Credential("login@mydomain.com", "secretpassword")
        credentialsManager.add("user", credential)

        val credential2 = credentialsManager.get("user")
        assertEquals(credential2?.password, credential.password)
    }
}