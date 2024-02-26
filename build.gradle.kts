plugins {
    id(libs.plugins.conventions.multiplatform.library.get().pluginId)
}

group = "org.timemates.credentials"

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlinx.serialization)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        jvmMain {
            dependencies {
                implementation(libs.microsoft.credential.storage)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.security.crypto)
            }
        }

        androidUnitTest {
            dependencies {
                implementation(libs.kotlin.test.junit)
                implementation(libs.robolectric)
            }
        }
    }
}

android {
    compileSdk = libs.versions.android.compile.sdk.get().toInt()
    namespace = "org.timemates.credentials"

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
        groupId = "org.timemates.credentials",
        artifactId = "credentials-manager",
        version = System.getenv("LIB_VERSION") ?: return@mavenPublishing,
    )

    pom {
        name.set("CredentialsManager")
        description.set("Multiplatform Kotlin library for storing key-value credentials.")
    }
}