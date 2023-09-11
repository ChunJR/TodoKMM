plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

version = "1.0.0"
val sqldelightVersion = "1.5.3"
val ktorVersion = "1.6.1"
val kodeinVersion = "7.6.0"
val logbackVersion = "1.0.0"
val serializationVersion = "1.1.0"
val coroutineVersion = "1.5.1-native-mt"

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
                implementation("com.squareup.sqldelight:runtime:$sqldelightVersion")
                implementation("org.kodein.di:kodein-di:$kodeinVersion")
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
                implementation("io.ktor:ktor-client-auth:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                implementation("ch.qos.logback:logback-classic:$logbackVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serializationVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion") {
                    version {
                        strictly(coroutineVersion)
                    }
                }
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.squareup.sqldelight:android-driver:$sqldelightVersion")
                implementation("io.ktor:ktor-client-android:$ktorVersion")
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependencies {
                implementation("com.squareup.sqldelight:native-driver:$sqldelightVersion")
                implementation("io.ktor:ktor-client-ios:$ktorVersion")
            }

            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
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
        minSdk = 21
        targetSdk = 33
    }
}