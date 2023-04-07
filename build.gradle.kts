/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: TruckSim-Telemetry-Kotlin
 *  Module: TruckSim-Telemetry-Kotlin
 *  Last modified: 09-02-23 00:57
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.10"
    `java-library`
    `maven-publish`
    id("org.sonarqube") version "4.0.0.2929"
    id("org.jetbrains.dokka") version "1.8.10"
    application
}

group = "cl.figonzal"
version = "1.1"

repositories {
    mavenCentral()
}

dependencies {

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    //JNA
    implementation("net.java.dev.jna:jna-platform:5.13.0")

    //LOGGER
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.5")

    runtimeOnly(group = "ch.qos.logback", name = "logback-classic", version = "1.4.5")

    testImplementation(kotlin("test"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("MainKt")
}

sonarqube {
    properties {
        property("sonar.projectName", "TruckSim-Telemetry-Kotlin")
        property("sonar.projectKey", "TruckSim-Telemetry-Kotlin")
        property("sonar.sourceEncoding", "UTF-8")
        property("sonar.sources", "src/main/kotlin")
    }
}

publishing {
    publications {
        create<MavenPublication>("TruckSim-Telemetry-Kotlin") {
            from(components["kotlin"])
        }
    }
}

tasks.dokkaHtml {
    outputDirectory.set(rootDir.resolve("docs"))
    failOnWarning.set(true)

    dokkaSourceSets.configureEach {
        suppressObviousFunctions.set(true)
        suppressGeneratedFiles.set(true)
        reportUndocumented.set(false)
        skipEmptyPackages.set(true)

        perPackageOption {
            matchingRegex.set(".*jna.*")
            suppress.set(true)
        }

        perPackageOption {
            matchingRegex.set(".*exceptions.*")
            suppress.set(true)
        }
    }
}
