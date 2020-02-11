import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.61"
    antlr
}

group = "Roche"
version = "1.0-SNAPSHOT"
description = """Myla Compiler"""

java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    antlr("org.antlr:antlr4:4.8")
    testImplementation("junit:junit:4.12")
}

val test: Test by tasks
test.testLogging.setEvents(setOf("PASSED", "FAILED", "SKIPPED"))

val compileKotlin: KotlinCompile by tasks
val compileTestKotlin: KotlinCompile by tasks

compileKotlin.kotlinOptions {
    jvmTarget = "11"
}
compileTestKotlin.kotlinOptions {
    jvmTarget = "11"
}

tasks.generateGrammarSource {
    maxHeapSize = "64m"
    arguments = arguments + listOf("-visitor", "-no-listener", "-Werror", "-long-messages")
}