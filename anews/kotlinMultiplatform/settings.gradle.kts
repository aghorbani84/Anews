pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    
    plugins {
        id("org.jetbrains.kotlin.multiplatform") version "2.0.21"
        id("com.android.library") version "8.5.2"
        id("org.jetbrains.compose") version "1.7.3"
    }
}

rootProject.name = "anews-kmp"

include(":shared")
