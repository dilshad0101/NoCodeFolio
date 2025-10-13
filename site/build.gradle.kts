import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
    alias(libs.plugins.kotlin.serialization)

}

group = "org.app.nocodefolio"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Powered by Kobweb")
            head.add{
                link( rel="preconnect", href="https://fonts.googleapis.com")
                link( rel="preconnect",href="https://fonts.gstatic.com") {attributes["crossorigin"] = ""}
                link( href="https://fonts.googleapis.com/css2?family=Lexend:wght@100..900&display=swap", rel="stylesheet")
            }
        }
    }
}

repositories {
    /* ... other repositories ... */
    maven(url = "https://jitpack.io")
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://maven.pkg.jetbrains.space/public/p/kotlin/dev")
    maven("https://maven.pkg.jetbrains.space/varabyte/p/kobweb/maven")
    mavenLocal()
    mavenLocal {
        content {
            includeGroup("dev.bitspittle")
        }
    }
}

kotlin {
    // This example is frontend only. However, for a fullstack app, you can uncomment the includeServer parameter
    // and the `jvmMain` source set below.
    configAsKobwebApplication("nocodefolio" /*, includeServer = true*/)
    js(IR)
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kobwebx.serialization.kotlinx)
        }
        js(IR){ }
        jsMain.dependencies {

            implementation("dev.bitspittle:firebase-kotlin-bindings:+")
           // implementation("com.github.stevdza-san:KotlinBootstrap:0.1.6")

            implementation(libs.compose.runtime)
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.fa)
            implementation(libs.kobwebx.markdown)
        }

        // Uncomment the following if you pass `includeServer = true` into the `configAsKobwebApplication` call.
//        jvmMain.dependencies {
//            compileOnly(libs.kobweb.api) // Provided by Kobweb backend at runtime
//        }
    }
}
