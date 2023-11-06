package lib.kotleni.credentials

interface CredentialsManager {
    fun initialize()
    fun add(key: String, credential: Credential)
    fun get(key: String) : Credential?
}

expect class CredentialsManagerImpl : CredentialsManager