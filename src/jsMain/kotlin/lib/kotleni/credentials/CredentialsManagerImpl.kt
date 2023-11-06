package lib.kotleni.credentials

import kotlinx.browser.document
import kotlinx.browser.localStorage
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import org.w3c.dom.Storage
import org.w3c.dom.get
import org.w3c.dom.set

actual class CredentialsManagerImpl : CredentialsManager {
    override fun initialize() { }

    override fun add(key: String, credential: Credential) {
        val json = Json.encodeToJsonElement(credential)
        localStorage[key] = json.toString()
    }

    override fun get(key: String): Credential? {
        val json = localStorage[key] ?: return null
        return Json.decodeFromString<Credential>(json)
    }
}