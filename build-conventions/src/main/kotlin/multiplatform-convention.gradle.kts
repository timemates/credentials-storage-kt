import org.jetbrains.kotlin.gradle.dsl.*

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    jvm {
        testRuns.named("test") {
            executionTask.configure {
                useJUnitPlatform()
            }
        }
    }

    androidTarget()

    js {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
    }
    jvmToolchain(11)

    explicitApi = ExplicitApiMode.Strict
}

android {
    compileSdk = 34

    namespace = "io.timemates.credentials"
}