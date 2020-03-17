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
jacoco {
    toolVersion = "0.8.5"
}

tasks.test {
    finalizedBy("jacocoTestReport")
    doLast {
        println("View code coverage at:")
        // println("file://$buildDir/reports/coverage/index.html")
        println("file://$buildDir/reports/jacoco/test/html/index.html")
    }
}

tasks.jacocoTestReport {
    reports {
        csv.isEnabled = true
        xml.isEnabled = true
        html.isEnabled = true
        // xml.destination = file("$buildDir/reports/coverage/jacoco.xml")
        // html.destination = file("$buildDir/reports/coverage/html")
    }
}

tasks.withType<JacocoReport> {
    classDirectories.setFrom(
        sourceSets.main.get().output.asFileTree.matching {
            exclude("generated")
        }
    )
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            element = "CLASS"
            excludes = listOf("generated.*")
            limit {
                minimum = "0.8".toBigDecimal()
            }
        }
    }
}

/*
JACOCO_SOURCE_PATH=src/main/java ./cc-test-reporter \
  format-coverage target/site/jacoco/jacoco.xml     \
  --input-type jacoco

  JACOCO_SOURCE_PATH=src/main/kotlin ./cc-test-reporter format-coverage build/reports/jacoco/test/jacocoTestReport.xml --input-type jacoco
  ./cc-test-reporter upload-coverage -r eb8d427a5e59a28b0825f99aa65d7cdab6afc0c41dffc2d45104b9b74e21cc97
 */
