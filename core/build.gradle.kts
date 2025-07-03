plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("com.google.devtools.ksp")
}

val koinVersion: String by project

dependencies {

    // Kotlin
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
    api("org.jetbrains.kotlinx:kotlinx-datetime:0.6.2")

    // Koin
    api("io.insert-koin:koin-core:$koinVersion")
    api("io.insert-koin:koin-annotations:2.1.0")
    ksp("io.insert-koin:koin-ksp-compiler:2.1.0")

    // Logging
    api("io.github.oshai:kotlin-logging-jvm:7.0.3")

    // Tests
    testImplementation(kotlin("test"))
}