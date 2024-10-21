plugins {
    alias(libs.plugins.movie.android.library)
}

android {
    namespace = "com.movie.mvi"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.material3)
}
