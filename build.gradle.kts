import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  application
  kotlin("jvm") version "1.6.20-dev-1357"
}

group = "me.breandan"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
  maven("https://jitpack.io")
  maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
}

dependencies {
  testImplementation(kotlin("test-junit"))
  implementation("ai.hypergraph:kotlingrad:0.4.6")
  implementation("ai.hypergraph:kaliningraph:0.1.8")
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
