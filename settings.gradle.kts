pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
rootProject.name = "Movies"
include(
    "app",
    "data",
    "domain",
    "utils",
    "home"
)
