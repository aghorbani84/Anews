plugins {
    kotlin("multiplatform") version "2.0.21"
    id("com.android.library") version "8.5.2"
    kotlin("plugin.serialization") version "2.0.21"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    
    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
                implementation("io.ktor:ktor-client-core:3.0.1")
                implementation("io.ktor:ktor-serialization-kotlinx-json:3.0.1")
                implementation("io.ktor:ktor-client-content-negotiation:3.0.1")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
                implementation("org.jetbrains.compose.runtime:runtime:1.7.3")
            }
        }
        
        androidMain {
            dependencies {
                implementation("io.ktor:ktor-client-android:3.0.1")
                implementation("androidx.core:core-ktx:1.15.0")
            }
        }
        
        iosMain {
            dependencies {
                implementation("io.ktor:ktor-client-darwin:3.0.1")
            }
        }
    }
}

android {
    namespace = "com.example.anews.shared"
    compileSdk = 35
    
    defaultConfig {
        minSdk = 24
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
