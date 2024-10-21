plugins {
    alias(libs.plugins.movie.jvm.library)
    alias(libs.plugins.movie.jvm.hilt)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}
