plugins {
    alias(libs.plugins.android.application)
//    alias(libs.plugins.org.jetbrains.kotlin.kapt)
//    kotlin("kapt")
//    id("org.jetbrains.kotlin.android")
//    kotlin("kapt")
//    alias(libs.plugins.jetbrains.kotlin.kapt)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.training.retrofitapp"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.training.retrofitapp"
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

//    implementation("com.squareup.retrofit2:retrofit:3.1.0-SNAPSHOT")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")
//    implementation("com.squareup.retrofit2:converter-gson:3.1.0")
    implementation("com.google.code.gson:gson:2.10.1")
    val lifecycle_version = "2.10.0"
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${lifecycle_version}")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${lifecycle_version}")
    // Annotation processor
//    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")
//    alias(libs.plugins.org.jetbrains.kotlin.kapt)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("com.squareup.okhttp3:logging-interceptor:5.3.0")
}