import com.movie.convention.implementation
import com.movie.convention.kapt
import com.movie.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class JvmHiltConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.kapt")
            }

            dependencies {
                implementation(libs.hilt.core)
                kapt(libs.hilt.compiler)
            }
        }
    }
}
