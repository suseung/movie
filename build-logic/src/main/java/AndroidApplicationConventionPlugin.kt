import com.android.build.api.dsl.ApplicationExtension
import com.movie.convention.MovieConfig
import com.movie.convention.MovieConfig.applicationId
import com.movie.convention.MovieConfig.minSdk
import com.movie.convention.MovieConfig.targetSdk
import com.movie.convention.MovieConfig.versionCode
import com.movie.convention.MovieConfig.versionName
import com.movie.convention.configureAndroidCompose
import com.movie.convention.configureKotlinAndroid
import com.movie.convention.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

internal class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)

                defaultConfig.apply {
                    applicationId = MovieConfig.applicationId
                    minSdk = MovieConfig.minSdk
                    targetSdk = MovieConfig.targetSdk
                    versionCode = MovieConfig.versionCode
                    versionName = MovieConfig.versionName

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    vectorDrawables {
                           useSupportLibrary = true
                    }
                }

                configureAndroidCompose(this)

                packaging {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                        excludes += "META-INF/gradle/incremental.annotation.processors"
                    }
                }

                buildTypes {
                    release {
                        isMinifyEnabled = false
                        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                    }
                }
            }

            dependencies {
                implementation(project(":data"))
                implementation(project(":domain"))
                implementation(project(":core:designsystem"))
                implementation(project(":core:resources"))
                implementation(project(":presentation:common"))
                implementation(project(":presentation:home"))
            }
        }
    }
}
