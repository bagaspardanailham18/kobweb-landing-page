import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.script

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
    //alias(libs.plugins.kobwebx.markdown)
}

group = "com.bagaspardanailham.kobwebcourse"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Powered by Kobweb")

            head.add {
                link(rel = "preconnect", href = "https://fonts.googleapis.com")
                link(rel = "preconnect", href = "https://fonts.gstatic.com") { attributes["crossorigin"] = "" }
                link(
                    href = "https://fonts.googleapis.com/css2?family=Roboto&display=swap",
                    rel = "stylesheet"
                )
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("kobwebcourse")

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk.core)
                implementation(libs.kobweb.silk.icons.fa)
                //implementation(libs.kobwebx.markdown)
            }
        }
//        val jvmMain by getting {
//            dependencies {
//                implementation(libs.kobweb.api)
//            }
//        }
    }
}
