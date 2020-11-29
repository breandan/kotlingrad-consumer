import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  application
  kotlin("jvm") version "1.4.20"
}

group = "me.breandan"
version = "1.0-SNAPSHOT"

repositories {
  jcenter()
  maven("https://jitpack.io")
  maven("https://dl.bintray.com/egor-bogomolov/astminer")
}

dependencies {
  testImplementation(kotlin("test-junit"))
  implementation("com.github.breandan:kotlingrad:0.3.9")
  implementation("com.github.breandan:kaliningraph:0.1.3")
}

application {
    mainClassName = "TestKt"
}

tasks.test {
  useJUnit()
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}
