plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-parcelize")
}

android {
    namespace = "edu.danialmkj.myrecipeapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "edu.danialmkj.myrecipeapplication"
        minSdk = 24
        targetSdk = 35
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    //compose view model
    implementation(libs.androidx.lifecycle.viewmodel.compose) // Or latest version
    implementation(libs.androidx.lifecycle.runtime.compose) // For lifecycle aware components
    // If you need SavedState support
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)

    //Network call (retrofit)
    implementation(libs.retrofit) // Or latest version
    implementation(libs.converter.gson) // For JSON parsing with Gson(convert json to kotlin object)
    implementation(libs.okhttp) // Or latest version (Retrofit's HTTP client)
    implementation(libs.logging.interceptor) //Optional: For logging Network Request

    implementation(libs.coil.compose) //Load Images


    val nav_version = "2.8.5"

    // Jetpack Compose integration
    implementation(libs.androidx.navigation.compose)




    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}