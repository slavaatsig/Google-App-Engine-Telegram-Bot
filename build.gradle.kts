import com.google.cloud.tools.gradle.appengine.appyaml.AppEngineAppYamlExtension

buildscript {
    repositories { jcenter() }
    dependencies { classpath("com.google.cloud.tools:appengine-gradle-plugin:2.0.1") }
}

apply {
    plugin("com.google.cloud.tools.appengine")
}

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM
    id("org.jetbrains.kotlin.jvm").version("1.3.40")
    // Apply the application to add support for building a CLI application
    application
    war
}

repositories {
    // Use jcenter for resolving your dependencies.
    jcenter()
    mavenCentral()
    // You can declare any Maven/Ivy/file repository here.
    maven(url = "https://jitpack.io")
}

dependencies {
    // Use the Kotlin JDK 8 standard library
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    // Telegram bot
    implementation("io.github.seik.kotlin-telegram-bot:telegram:0.3.8")
}

application {
    // Define the main class for the application
    mainClassName = "com.example.gae.telegram.BotKt"
}

configure<AppEngineAppYamlExtension> {
    deploy {
        projectId = "YOUR_GOOGLE_CLOUD_PROJECT"
        version = "1"
        stopPreviousVersion = true  // default - stop the current version
        promote = true              // default - & make this the current version
    }
}

