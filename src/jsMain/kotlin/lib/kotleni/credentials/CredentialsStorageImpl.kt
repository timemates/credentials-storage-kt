package lib.kotleni.credentials

import kotlinx.browser.localStorage
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import org.w3c.dom.get
import org.w3c.dom.set

actual class CredentialsStorageImpl : CredentialsStorage {
    override fun initialize() { }

    override fun getString(key: String): String? {
        return localStorage[key]
    }

    override fun getInt(key: String): Int? {
        return localStorage[key]?.toIntOrNull()
    }

    override fun getLong(key: String): Long? {
        return localStorage[key]?.toLongOrNull()
    }

    override fun getBoolean(key: String): Boolean? {
        return localStorage[key]?.toBooleanStrictOrNull()
    }

    override fun setString(key: String, value: String) {
        localStorage[key] = value
    }

    override fun setInt(key: String, value: Int) {
        localStorage[key] = value.toString()
    }

    override fun setLong(key: String, value: Long) {
        localStorage[key] = value.toString()
    }

    override fun setBoolean(key: String, value: Boolean) {
        localStorage[key] = value.toString()
    }

    override fun clear(key: String) {
        localStorage.clear()
    }
}