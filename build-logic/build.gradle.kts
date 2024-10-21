plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "movie.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "movie.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidHilt") {
            id = "movie.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("jvmHilt") {
            id = "movie.jvm.hilt"
            implementationClass = "JvmHiltConventionPlugin"
        }
        register("jvmLibrary") {
            id = "movie.jvm.library"
            implementationClass = "JvmLibraryPlugin"
        }
        register("androidFeature") {
            id = "movie.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
    }
}
