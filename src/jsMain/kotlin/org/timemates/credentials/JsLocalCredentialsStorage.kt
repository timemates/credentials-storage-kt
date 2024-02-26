package org.timemates.credentials

import kotlinx.browser.localStorage
import org.w3c.dom.get
import org.w3c.dom.set

/**
 * Javascript local storage implementation of credentials storage
 */
public class JsLocalCredentialsStorage : CredentialsStorage {
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
}