plugins {
    id(libs.plugins.conventions.multiplatform.library.get().pluginId)
}

group = "com.timemates.credentials"

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.serialization)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(libs.microsoft.credential.storage)
            }
        }
        val jvmTest by getting

        val jsMain by getting
        val jsTest by getting

        val androidMain by getting {
            dependencies {
                implementation(libs.security.crypto)
            }
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(libs.kotlin.test.junit)
                implementation(libs.robolectric)
            }
        }
    }
}

android {
    compileSdk = libs.versions.android.compile.sdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.min.sdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    testOptions {
        unitTests {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
    }
}

mavenPublishing {
    coordinates(
        groupId = "io.timemates.credentials",
        artifactId = "credentials-manager",
        version = System.getenv("LIB_VERSION")  ?: return@mavenPublishing,
    )

    pom {
        name.set("CredentialsManager")
        description.set("Multiplatform Kotlin library for storing key-value credentials.")
    }
}