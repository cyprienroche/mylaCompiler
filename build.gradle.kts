import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.61"
    id("org.jmailen.kotlinter") version "2.3.0"
    antlr
    application
    distribution
}

group = "Roche"
version = "0.1.0"
description = """Myla Compiler"""
application.mainClassName = "MainKt"

java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

tasks.jar {
    manifest.attributes(mapOf("Implementation-Title" to project.name, "Implementation-Version" to project.version))
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    antlr("org.antlr:antlr4:4.8")
    testImplementation("junit:junit:4.12")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
}

kotlinter {
    indentSize = 2
}

val test: Test by tasks
test.testLogging.setEvents(setOf("PASSED", "FAILED", "SKIPPED"))

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "11"
compileKotlin.dependsOn(tasks.generateGrammarSource)

val generatedjavaFolder = "src/main/java/generated"

tasks.generateGrammarSource {
    maxHeapSize = "64m"
    outputDirectory = File(generatedjavaFolder)
    arguments = arguments + listOf("-visitor", "-no-listener", "-Werror", "-long-messages", "-package", "generated")
}

val clean: Delete by tasks
clean.delete(generatedjavaFolder)
