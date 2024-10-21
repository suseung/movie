plugins {
    alias(libs.plugins.movie.android.library)
    alias(libs.plugins.movie.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.movie.data"
}

dependencies {
    implementation(project(":domain"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(libs.kotlinx.serialization.json)

    implementation(libs.bundles.retrofit2)
    implementation(libs.bundles.okhttp3)

    implementation(libs.androidx.datastore)
}
