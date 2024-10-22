plugins {
    alias(libs.plugins.movie.android.library)
}

android {
    namespace = "com.movie.designsystem"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.material3)
    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.bundles.androidx.ui.compose)
    debugImplementation(libs.bundles.androidx.ui.compose.debug)
}
