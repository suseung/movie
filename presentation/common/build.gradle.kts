plugins {
    alias(libs.plugins.movie.android.library)
    alias(libs.plugins.movie.android.hilt)
}

android {
    namespace = "com.movie.common"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.material3)
    implementation(libs.androidx.viewModel.lifecycle)
}
