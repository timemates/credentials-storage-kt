package io.timemates.credentials.utils

import io.timemates.credentials.CredentialsStorage

class InMemoryCredentialsStorage : CredentialsStorage {
    private val hashMap: HashMap<String, Any> = HashMap()

    override fun getString(key: String): String? {
        return hashMap[key] as? String
    }

    override fun getInt(key: String): Int? {
        return hashMap[key] as? Int
    }

    override fun getLong(key: String): Long? {
        return hashMap[key] as? Long
    }

    override fun getBoolean(key: String): Boolean? {
        return hashMap[key] as? Boolean
    }

    override fun setString(key: String, value: String) {
        hashMap[key] = value
    }

    override fun setInt(key: String, value: Int) {
        hashMap[key] = value
    }

    override fun setLong(key: String, value: Long) {
        hashMap[key] = value
    }

    override fun setBoolean(key: String, value: Boolean) {
        hashMap[key] = value
    }
}
