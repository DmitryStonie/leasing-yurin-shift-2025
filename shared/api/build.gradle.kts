import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlinx-serialization")
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
    namespace = "com.dmitrystonie.leasingapp.shared.api"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val leasingBaseUrl = getLeasingBaseUrl()
        val leasingImagesBaseUrl = getLeasingImagesBaseUrl()

        buildConfigField("String", "LEASING_API_BASE_URL", "\"${leasingBaseUrl}\"")
        buildConfigField("String", "LEASING_IMAGES_BASE_URL", "\"${leasingImagesBaseUrl}\"")
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
    }

}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    debugImplementation(libs.ui.tooling)
    implementation(libs.material3)
    implementation(libs.androidx.navigation.compose)

}