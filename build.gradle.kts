@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform") version "2.0.0"
    id("org.jetbrains.kotlinx.benchmark") version "0.4.11"
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
                implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.11")
            }
        }
    }
}

application {
    mainClass = "MainKt"
}

benchmark {
    targets {
        register("jvmMain")
        register("wasmJsMain")
    }
    configurations {
        named("main") {
            warmups = 20
            iterations = 10
            iterationTime = 3
            iterationTimeUnit = "s"
        }
    }
}

allOpen {
    annotation("org.openjdk.jmh.annotations.State")
}