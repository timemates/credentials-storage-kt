package lib.kotleni.credentials

class CredentialsNotInitializedException: Exception(
    "Credentials manager not initialized.\n" +
            "You should invoke initialize() before using."
)