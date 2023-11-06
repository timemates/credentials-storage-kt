package lib.kotleni.credentials

import com.microsoft.credentialstorage.SecretStore
import com.microsoft.credentialstorage.StorageProvider
import com.microsoft.credentialstorage.model.StoredCredential

actual class CredentialsManagerImpl : CredentialsManager {
    private var credentialsStorage: SecretStore<StoredCredential>? = null

    override fun initialize() {
        credentialsStorage = StorageProvider.getCredentialStorage(
            true,
            StorageProvider.SecureOption.REQUIRED
        )
    }

    override fun add(key: String, credential: Credential) {
        if(credentialsStorage == null) throw CredentialsNotInitializedException()

        val storedCredential = StoredCredential(credential.login, credential.password.toCharArray())
        credentialsStorage?.add(key, storedCredential)
        storedCredential.clear()
    }

    override fun get(key: String): Credential? {
        if(credentialsStorage == null) throw CredentialsNotInitializedException()

        return credentialsStorage?.get(key)
            ?.let { Credential(it.username, it.password.concatToString()) }
    }
}