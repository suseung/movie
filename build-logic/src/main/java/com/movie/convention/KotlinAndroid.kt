package com.movie.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        defaultConfig {
            compileSdk = MovieConfig.compileSdk
            minSdk = MovieConfig.minSdk
        }

        compileOptions {
            sourceCompatibility = MovieConfig.javaCompileTarget
            targetCompatibility = MovieConfig.javaCompileTarget
        }

        buildFeatures {
            compose = true
        }
    }

    configureKotlin()
}

internal fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = MovieConfig.javaCompileTarget.toString()
        }
    }
}
