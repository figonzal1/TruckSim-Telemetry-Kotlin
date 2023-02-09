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
    kotlin("jvm") version "1.7.20"
    `java-library`
    `maven-publish`
    id("org.sonarqube") version "3.5.0.2730"
    id("org.jetbrains.dokka") version "1.7.20"
    application
}

group = "cl.figonzal"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    //JNA
    implementation("net.java.dev.jna:jna-platform:5.12.1")

    //LOGGER
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.4")

    runtimeOnly(group = "ch.qos.logback", name = "logback-classic", version = "1.4.5")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
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
        property("sonar.login", "sqp_e5335303f0f17d1afcfdc16e39ae44e3dd720350")
    }
}

publishing {
    publications {
        create<MavenPublication>("TruckSim-Telemetry-Kotlin") {
            from(components["kotlin"])
        }
    }
}
