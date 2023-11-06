plugins {
    id("java")
}

group = "lib.kotleni"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.java.dev.jna:jna:4.5.0")
    implementation("org.slf4j:slf4j-jdk14:+")
    testImplementation("junit:junit:+")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}