import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("kotlinx-serialization")
    id("com.google.dagger.hilt.android")
}

fun getLeasingBaseUrl(): String {
    val properties = Properties()
    val stream = project.file("api.properties").inputStream()
    properties.load(stream)
    stream.close()
    return properties.getProperty("LEASING_API_BASE_URL", "")
}

fun getLeasingImagesBaseUrl(): String {
    val properties = Properties()
    val stream = project.file("api.properties").inputStream()
    properties.load(stream)
    stream.close()
    return properties.getProperty("LEASING_IMAGES_BASE_URL", "")
}

android {
    namespace = "com.dmitrystonie.leasingapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.dmitrystonie.leasingapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val leasingBaseUrl = getLeasingBaseUrl()
        val leasingImagesBaseUrl = getLeasingImagesBaseUrl()

        buildConfigField("String", "LEASING_API_BASE_URL", "\"${leasingBaseUrl}\"")
        buildConfigField("String", "LEASING_IMAGES_BASE_URL", "\"${leasingImagesBaseUrl}\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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
        buildConfig = true
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    debugImplementation(libs.ui.tooling)
    implementation(libs.material3)
    implementation(libs.androidx.runtime.livedata)

    // hilt
    implementation("com.google.dagger:hilt-android:2.56.1")
    kapt("com.google.dagger:hilt-android-compiler:2.56.1")
    implementation("androidx.fragment:fragment-ktx:1.8.8")

    // retrofit
    val okhttpVersion = "4.12.0"
    val retrofitVersion = "2.11.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")

    // glide
    implementation("com.github.bumptech.glide:compose:1.0.0-beta01")

    // hilt compose
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
}