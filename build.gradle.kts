// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
//    alias(libs.plugins.org.jetbrains.kotlin.kapt) apply false
//    id("org.jetbrains.kotlin.android") version "1.9.0" apply false // Version defined here
//    kotlin("kapt") version "2.1.20" apply false
    id("com.google.devtools.ksp") version "2.3.4" apply false
}
