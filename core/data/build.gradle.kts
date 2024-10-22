import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.movie.android.library)
    alias(libs.plugins.movie.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.movie.data"

    defaultConfig.apply {
        val apiKey = gradleLocalProperties(projectRootDir = rootDir, providers = providers).getProperty("api.key")
        buildConfigField("String", "apiKey", apiKey)
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":core:domain"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(libs.kotlinx.serialization.json)

    implementation(libs.bundles.retrofit2)
    implementation(libs.bundles.okhttp3)

    implementation(libs.androidx.datastore)
    implementation(libs.chucker)
}
