plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    // added
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

kotlin {
    jvmToolchain(11)
}

android {
    namespace = "com.rpm.emptydaggerproject"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.rpm.emptydaggerproject"
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
    }
}

dependencies {
    // defaults
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // ** added dependencies **
    // core
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.service)
    implementation(libs.androidx.datastore)
    implementation(libs.androidx.work)
    // Hilt
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation)
    implementation(libs.hilt.worker)
    // retrofit
    implementation(libs.retrofit.android)
    implementation(libs.retrofit.gson)
    // okhttp
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    // room
    ksp(libs.room.compiler)
    implementation(libs.room.compiler)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    // Firebase
    // implementation(platform(libs.firebase.bom))
    // implementation(libs.firebase.analytics)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // added
    testImplementation(libs.hilt.testing)
    testImplementation(libs.room.test)
    testImplementation (libs.mockk)
    androidTestImplementation (libs.mockk.android)
}