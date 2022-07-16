import org.gradle.api.JavaVersion.VERSION_15

plugins {
    application
    kotlin("jvm") version "1.7.10"
}

group = "me.breandan"
version = "1.0-SNAPSHOT"

kotlin.jvmToolchain {
    (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(15))
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("ai.hypergraph:kotlingrad:0.4.7")
}

application {
    mainClass.set("TestKt")
}

tasks.compileKotlin {
  kotlinOptions.jvmTarget = VERSION_15.toString()
}