plugins {
    id(libs.plugins.conventions.multiplatform.library.get().pluginId)
}

group = "com.timemates.credentials"

kotlin {
    val hostOs = System.getProperty("os.name")
    val isArm64 = System.getProperty("os.arch") == "aarch64"
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" && isArm64 -> macosArm64("native")
        hostOs == "Mac OS X" && !isArm64 -> macosX64("native")
        hostOs == "Linux" && isArm64 -> linuxArm64("native")
        hostOs == "Linux" && !isArm64 -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            compilations["main"].cinterops {
                val lib by creating {
                    packageName = "io.timemates.credentials.native"
                    includeDirs("$projectDir/src/nativeMain/cpp/")
                    defFile = file("$projectDir/src/nativeMain/lib.def")

                    //compilerOpts("-F${projectDir}")
                }
            }
            executable {
                entryPoint = "main"
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

        val nativeMain by getting
        val nativeTest by getting {
            dependsOn(nativeMain)
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