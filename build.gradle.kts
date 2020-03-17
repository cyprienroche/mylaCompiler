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

sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
    kotlin.srcDir("src/main/kotlin")
}

tasks.jar {
    manifest.attributes(mapOf("Implementation-Title" to project.name, "Implementation-Version" to project.version))
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    antlr("org.antlr:antlr4:4.8")
    testImplementation("org.junit.jupiter:junit-jupiter:5.6.0")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
}
tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

// config JVM target to 11 for kotlin compilation tasks
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "11"
    dependsOn(tasks.generateGrammarSource)
}

// ANTLR configuration
val generatedJavaFolder = "src/main/java/generated"

tasks.generateGrammarSource {
    maxHeapSize = "64m"
    outputDirectory = File(generatedJavaFolder)
    arguments = arguments + listOf("-visitor", "-no-listener", "-Werror", "-long-messages", "-package", "generated")
}

tasks.clean {
    delete(generatedJavaFolder)
}

// Jacoco configuration
jacoco {
    toolVersion = "0.8.5"
}

tasks.test {
    finalizedBy("jacocoTestReport")
    doLast {
        println("View code coverage at:")
        println("file://$buildDir/reports/jacoco/test/html/index.html")
    }
}

tasks.jacocoTestReport {
    reports {
        csv.isEnabled = false
        xml.isEnabled = true
        html.isEnabled = true
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
