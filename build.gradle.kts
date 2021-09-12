import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.JavaVersion.VERSION_15

plugins {
  application
  kotlin("jvm") version "1.6.20-dev-1357"
}

group = "me.breandan"
version = "1.0-SNAPSHOT"

java.toolchain {
  languageVersion.set(JavaLanguageVersion.of(15))
  vendor.set(JvmVendorSpec.ADOPTOPENJDK)
  implementation.set(JvmImplementation.J9)
}

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
  kotlinOptions.jvmTarget = VERSION_15.toString()
}
