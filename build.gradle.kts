plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.android.library)
}

group = "lib.kotleni"
version = "1.0-SNAPSHOT"

kotlin {
    androidTarget()

    jvm {
        jvmToolchain(8)
        //withJava()
        testRuns.named("test") {
            executionTask.configure {
                useJUnitPlatform()
            }
        }
    }
    js {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.serialization)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(project(mapOf("path" to ":jvmcredentials")))
            }
        }
        val jvmTest by getting {
            dependencies {
                //implementation(kotlin("test"))
            }
        }
        val jsMain by getting
        val jsTest by getting
        val androidMain by getting {
            dependencies {
                implementation("androidx.security:security-crypto:1.0.0")
            }
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(libs.kotlin.test.junit)
                implementation("io.mockk:mockk:+")
                implementation("org.robolectric:robolectric:4.9")
            }
        }
    }
}

android {
    val _minSdk = 23
    val _compileSdk = 32

    compileSdk = _compileSdk

    defaultConfig {
        minSdk = _minSdk
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        jvmToolchain(11)
    }

    testOptions {
        unitTests {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
    }

//    testOptions {
//        unitTests {
//            includeAndroidResources = true
//        }
//    }
}