plugins {
    alias(libs.plugins.movie.android.library)
}

android {
    namespace = "com.movie.designsystem"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}
