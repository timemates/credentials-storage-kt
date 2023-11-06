package lib.kotleni.credentials

import com.microsoft.credentialstorage.SecretStore
import com.microsoft.credentialstorage.StorageProvider
import com.microsoft.credentialstorage.model.StoredCredential

/**
 * Windows, linux and macOS implementation of credentials manager.
 */
class DesktopCredentialsStorage : CredentialsStorage {
    private var credentialsStorage: SecretStore<StoredCredential> = StorageProvider.getCredentialStorage(
        true,
        StorageProvider.SecureOption.REQUIRED
    )

    /**
     * Get value or null from credentials storage by key.
     */
    private fun getValueOrNull(key: String): String? {
        val passwordArray = credentialsStorage?.get(key)?.password ?: return null
        return passwordArray.concatToString()
    }

    /**
     * Set value by key in credentials manager.
     */
    private fun setValue(key: String, value: String) {
        // Remove prev value if exist
        if(credentialsStorage?.get(key) != null) {
            credentialsStorage?.delete(key)
        }

        credentialsStorage?.add(key, StoredCredential(key, value.toCharArray()))
    }

    override fun getString(key: String): String? {
        return getValueOrNull(key)
    }

    override fun getInt(key: String): Int? {
        return getValueOrNull(key)?.toIntOrNull()
    }

    override fun getLong(key: String): Long? {
        return getValueOrNull(key)?.toLongOrNull()
    }

    override fun getBoolean(key: String): Boolean? {
        return getValueOrNull(key)?.toBooleanStrictOrNull()
    }

    override fun setString(key: String, value: String) {
        return setValue(key, value)
    }

    override fun setInt(key: String, value: Int) {
        return setValue(key, value.toString())
    }

    override fun setLong(key: String, value: Long) {
        return setValue(key, value.toString())
    }

    override fun setBoolean(key: String, value: Boolean) {
        return setValue(key, value.toString())
    }
}