import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.61"
    id("org.jmailen.kotlinter") version "2.3.0"
    jacoco
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

val test: Test by tasks
test.testLogging.setEvents(setOf("PASSED", "FAILED", "SKIPPED"))

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "11"
compileKotlin.dependsOn(tasks.generateGrammarSource)

// ANTLR configuration
val generatedjavaFolder = "src/main/java/generated"

tasks.generateGrammarSource {
    maxHeapSize = "64m"
    outputDirectory = File(generatedjavaFolder)
    arguments = arguments + listOf("-visitor", "-no-listener", "-Werror", "-long-messages", "-package", "generated")
}

val clean: Delete by tasks
clean.delete(generatedjavaFolder)

// Jacoco configuration
jacoco.toolVersion = "0.8.5"

tasks.jacocoTestReport {
    reports {
        xml.isEnabled = false
        csv.isEnabled = false
        html.destination = file("$buildDir/reports/coverage")
    }
}

tasks.withType<JacocoReport> {
    classDirectories.setFrom(
        sourceSets.main.get().output.asFileTree.matching {
            exclude("generated")
        }
    )
}

tasks.test {
    finalizedBy("jacocoTestReport")
    doLast {
        println("View code coverage at:")
        println("file://$buildDir/reports/coverage/index.html")
    }
}
