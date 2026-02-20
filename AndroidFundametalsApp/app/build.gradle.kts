plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
//    alias(libs.plugins.kotlin.android)
//    alias(libs.plugins.ksp)

//    id("com.google.devtools.ksp")
}

android {
    namespace = "com.training.androidfundametalsapp"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.training.androidfundametalsapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(project(":libraryofalltopics"))
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.ext.junit)
//    androidTestImplementation(libs.espresso.core)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    implementation("androidx.compose.material:material-icons-extended:1.7.8")
//    implementation(libs.androidx.compose.material)
    implementation("com.google.code.gson:gson:2.13.2")
//    implementation(libs.converter.gson)
    val lifecycle_version = "2.10.0"
    implementation(libs.androidx.room.runtime)
//    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${lifecycle_version}")
}