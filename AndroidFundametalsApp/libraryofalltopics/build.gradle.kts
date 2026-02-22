/*
plugins {
    alias(libs.plugins.android.library)
//    alias(libs.plugins.ksp)
//    id("com.google.devtools.ksp")

//    alias(libs.plugins.kotlin.android)
//    alias(libs.plugins.google.ksp)
}

android {
    namespace = "com.training.libraryofalltopics"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
//        compose = true
//        viewBinding = true
        dataBinding = true
    }

}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    val lifecycle_version = "2.10.0"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

//    implementation(libs.androidx.room.runtime)
//    implementation(libs.androidx.room.ktx)
//    ksp(libs.androidx.room.compiler)

}*/

plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.training.libraryofalltopics"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
//        compose = true
//        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.retrofit)
    implementation(libs.converter.gson)

//    val lifecycle_version = "2.10.0"
//
//    // ViewModel
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${lifecycle_version}")
}
