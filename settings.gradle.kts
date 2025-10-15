pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
    }
}


gradle.settingsEvaluated {
    fun RepositoryHandler.kobwebSnapshots() {
        maven("https://central.sonatype.com/repository/maven-snapshots/") {
            mavenContent {
                includeGroupByRegex("com\\.varabyte\\.kobweb.*")
                snapshotsOnly()
            }
        }
    }

    pluginManagement.repositories { kobwebSnapshots() }
    dependencyResolutionManagement.repositories { kobwebSnapshots() }
}

rootProject.name = "nocodefolio"

include(":site")
