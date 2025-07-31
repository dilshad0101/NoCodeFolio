package org.app.nocodefolio.components.models

import org.app.nocodefolio.components.utils.Res


enum class Skill(
    val skillName: String,
    val level: String,
    val iconResLight: String,
    val iconResDark: String,
) {
    AndroidStudio(
        skillName = "Android Studio",
        level = "Skilled",
        iconResLight = Res.Images.ANDROID_STUDIO_DARK_LOGO,
        iconResDark = Res.Images.ANDROID_STUDIO_LIGHT_LOGO,
    ),
    IntellijIdea(
       skillName = "IntelliJ IDEA",
        level = "Skilled",
        iconResLight = Res.Images.INTELLIJ_IDEA_LOGO,
        iconResDark = Res.Images.INTELLIJ_IDEA_LOGO,
    ),

    Kotlin(
       skillName = "Kotlin",
        level = "Skilled",
        iconResLight = Res.Images.KOTLIN_LOGO,
        iconResDark = Res.Images.KOTLIN_LOGO,
    ),

    Java(
        skillName = "Java",
        level = "Adept",
        iconResLight = Res.Images.JAVA_LOGO,
        iconResDark = Res.Images.JAVA_LOGO,
    ),

    CPP(
        skillName = "C++",
        level = "Skilled",
        iconResLight = Res.Images.CPP_LOGO,
        iconResDark = Res.Images.CPP_LOGO,
    ),

    Compose(
        skillName = "Compose",
        level = "Skilled",
        iconResLight = Res.Images.COMPOSE_LOGO,
        iconResDark = Res.Images.COMPOSE_LOGO,
    ),

    Ktor(
        skillName = "Ktor",
        level = "Novice",
        iconResLight = Res.Images.KTOR_LOGO,
        iconResDark = Res.Images.KTOR_LOGO,
    ),

    Jetpack(
        skillName = "Jetpack",
        level = "Skilled",
        iconResLight = Res.Images.JETPACK_DARK_LOGO,
        iconResDark = Res.Images.JETPACK_LIGHT_LOGO,
    ),

    Firebase(
        skillName = "Firebase",
        level = "Adept",
        iconResLight = Res.Images.FIREBASE_LOGO,
        iconResDark = Res.Images.FIREBASE_LOGO,
    ),

    Github(
        skillName = "GitHub",
        level = "Skilled",
        iconResLight = Res.Images.GITHUB_DARK_LOGO,
        iconResDark = Res.Images.GITHUB_LIGHT_LOGO,
    ),

    Gradle(
        skillName = "Gradle",
        level = "Adept",
        iconResLight = Res.Images.GRADLE_DARK_LOGO,
        iconResDark = Res.Images.GRADLE_LIGHT_LOGO,
    ),

    Git(
        skillName = "Git",
        level = "Skilled",
        iconResLight = Res.Images.GIT_LOGO,
        iconResDark = Res.Images.GIT_LOGO,
    ),

    Figma(
        skillName = "Figma",
        level = "Adept",
        iconResLight = Res.Images.FIGMA_LOGO,
        iconResDark = Res.Images.FIGMA_LOGO,
    ),

    Python(
        skillName = "Python",
        level = "Skilled",
        iconResLight = Res.Images.PYTHON_LOGO,
        iconResDark = Res.Images.PYTHON_LOGO,
    ),

    Markdown(
        skillName = "Markdown",
        level = "Adept",
        iconResLight = Res.Images.MARKDOWN_DARK_LOGO,
        iconResDark = Res.Images.MARKDOWN_LIGHT_LOGO,
    ),

}

