@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.conventions.multiplatform.library.get().pluginId)
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.credentialsManagerLib)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

android {
    compileSdk = libs.versions.android.compile.sdk.get().toInt()
}

mavenPublishing {
    coordinates(
        groupId = "io.timemates.credentials",
        artifactId = "credentials-manager-inmemory",
        version = System.getenv("LIB_VERSION") ?: return@mavenPublishing,
    )

    pom {
        name.set("CredentialsManager InMemory")
        description.set("In-memory implementation for multiplatform Kotlin library for storing key-value credentials.")
    }
}