plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    val coroutinesVersion = "1.7.1"
    val ktorVersion = "2.3.2"
    val sqlDelightVersion = "1.5.5"
    val dateTimeVersion = "0.4.0"
    val kodeinVersion = "7.6.0"
    val logbackVersion = "1.4.8"
    val napierVersion = "1.5.0"
    val serializationVersion = "1.5.1"
    val coroutineVersion = "1.5.1-native-mt"

    sourceSets {
        targetHierarchy.default()

        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:$dateTimeVersion")
                implementation("org.kodein.di:kodein-di:7.6.0")
                implementation("org.kodein.di:kodein-di-framework-android-x:7.6.0")
                implementation("ch.qos.logback:logback-classic:$logbackVersion")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:$ktorVersion")
                implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")
            }
        }
        val iosMain by getting {
            // ...
            dependencies {
                implementation("io.ktor:ktor-client-ios:$ktorVersion")
                implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
            }
        }
    }
}

sqldelight {
    database("TodoDatabase") {
        packageName = "com.example.todokmm.database"
        sourceFolders = listOf("sqldelight")
    }
}

android {
    namespace = "com.example.todokmm"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}