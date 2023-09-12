buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.21")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.44.2")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.8.21")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version("8.2.0-alpha03").apply(false)
    id("com.android.library").version("8.2.0-alpha03").apply(false)
    id("com.squareup.sqldelight").version("1.5.5")
    id("com.google.dagger.hilt.android").version("2.42").apply(false)
    kotlin("android").version("1.8.21").apply(false)
    kotlin("multiplatform").version("1.8.21").apply(false)
    kotlin("jvm").version("1.8.21")
}