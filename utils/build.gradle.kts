@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

dependencies {
    implementation(projects.credentialsManagerLib)
    testImplementation(libs.kotlin.test.junit)
}
