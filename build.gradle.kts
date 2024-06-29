@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform") version "2.0.0"
    id("org.jetbrains.kotlinx.benchmark") version "0.4.10"
    id("org.jetbrains.kotlin.plugin.allopen") version "2.0.0"
    
    java
    application
}

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        withJava()
    }
    wasmJs {
        browser()
        nodejs()
    }
    
    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.10")
            }
        }
    }
}

application {
    mainClass = "MainKt"
}