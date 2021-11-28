import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

object PluginVersions {
    const val AGP = "7.0.3"
    const val KOTLIN = "1.5.31"
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginVersions.AGP}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersions.KOTLIN}")
}