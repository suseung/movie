plugins {
    alias(libs.plugins.movie.android.library)
}

android {
    namespace = "com.movie.resources"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}
