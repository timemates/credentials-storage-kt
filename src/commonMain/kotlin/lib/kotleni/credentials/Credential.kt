package lib.kotleni.credentials

import kotlinx.serialization.Serializable

@Serializable
data class Credential(
    val login: String,
    val password: String
)