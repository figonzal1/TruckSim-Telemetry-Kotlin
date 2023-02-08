/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry
 *  Last modified: 08-02-23 12:39
 */



import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    `java-library`
    `maven-publish`
    id("org.sonarqube") version "3.5.0.2730"
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
        property("sonar.projectName", "ETS2-Telemetry")
        property("sonar.projectKey", "ETS2-Telemetry")
        property("sonar.sourceEncoding", "UTF-8")
        property("sonar.sources", "src/main/kotlin")
        property("sonar.login", "sqp_3b70351f15237c561b839f18563d78ca3918cf6c")
    }
}

publishing {
    publications {
        create<MavenPublication>("ETS2-Telemetry") {
            from(components["kotlin"])
        }
    }
}
