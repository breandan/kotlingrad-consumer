import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  application
  kotlin("jvm") version "1.4.10"
}

group = "me.breandan"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    maven("https://jitpack.io")
    maven("https://dl.bintray.com/mipt-npm/dev")
    maven("https://dl.bintray.com/hotkeytlt/maven")
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
    maven("https://dl.bintray.com/egor-bogomolov/astminer")
    maven("https://maven.jzy3d.org/releases")
    maven("https://jetbrains.bintray.com/lets-plot-maven")
    maven("http://logicrunch.research.it.uu.se/maven/")
    maven("https://clojars.org/repo")
}

dependencies {
  testImplementation(kotlin("test-junit"))
  implementation("com.github.breandan:kotlingrad:0.3.7")
  implementation("com.github.breandan:kaliningraph:0.1.2")
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
