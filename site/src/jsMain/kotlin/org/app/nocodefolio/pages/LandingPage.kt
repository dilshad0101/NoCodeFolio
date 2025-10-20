package org.app.nocodefolio.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.ShapeMargin
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.shapeMargin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.forms.TextInput
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.app.nocodefolio.HeadlineTextStyle
import org.app.nocodefolio.SubheadlineTextStyle
import org.app.nocodefolio.components.SectionDiscriptionStyle
import org.app.nocodefolio.components.utils.Gap
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Div

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.margin
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.TextInput
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.app.nocodefolio.HeadlineTextStyle
import org.app.nocodefolio.components.SectionDiscriptionStyle
import org.app.nocodefolio.components.data.Project
import org.app.nocodefolio.components.data.Skill
import org.app.nocodefolio.components.data.Social
import org.app.nocodefolio.components.data.UserData
import org.app.nocodefolio.components.data.writeUserData
import org.app.nocodefolio.components.utils.Gap
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Page("register")
@Composable
fun RegisterPage() {
    // Basic user info
    val scope = rememberCoroutineScope()
    var name by remember { mutableStateOf("") }
    var role by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var about by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var getInTouchDescription by remember { mutableStateOf("") }

    // Lists
    var projects by remember { mutableStateOf(listOf(Project())) }
    var skills by remember { mutableStateOf(listOf(Skill())) }
    var socials by remember { mutableStateOf(listOf(Social())) }

    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(topBottom = 6.cssRem, leftRight = 2.cssRem),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title
        Div(attrs = HeadlineTextStyle.toAttrs()) {
            SpanText(
                text = "Create Your Portfolio",
                modifier = SectionDiscriptionStyle.toModifier()
                    .textAlign(TextAlign.Center)
                    .fontSize(2.5.cssRem)
                    .color(
                        when (ColorMode.current) {
                            ColorMode.LIGHT -> Colors.Gray
                            ColorMode.DARK -> Colors.LightGray
                        }
                    )
            )
        }

        Gap(1.5.cssRem)

        // --- Input Field Helper ---
        @Composable
        fun inputField(label: String, value: String, onChange: (String) -> Unit) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .backgroundColor(rgba(39, 39, 39, 0.5))
                    .padding(1.2.cssRem)
                    .margin(topBottom = 0.3.cssRem)
                    .fillMaxWidth()
                    .borderRadius(10.px)
            ) {
                SpanText(text = label, modifier = Modifier.color(Colors.LightGray))
                TextInput(
                    text = value,
                    onTextChange = { onChange(it) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        // --- Basic Info ---
        inputField("Name", name) { name = it }
        inputField("Email", email) { email = it }
        inputField("Role", role) { role = it }
        inputField("About", about) { about = it }
        inputField("Country", country) { country = it }
        inputField("Get In Touch Description", getInTouchDescription) { getInTouchDescription = it }

        Gap(1.cssRem)

        // --- Projects Section ---
        SectionHeader("Projects")
        projects.forEachIndexed { index, project ->
            EntityCard(
                onRemove = { projects = projects.filterIndexed { i, _ -> i != index } }
            ) {
                inputField("Project Name", project.name) {
                    projects = projects.toMutableList().apply { this[index] = project.copy(name = it) }
                }
                inputField("Image URL", project.imageUrl) {
                    projects = projects.toMutableList().apply { this[index] = project.copy(imageUrl = it) }
                }
                inputField("Redirect URL", project.redirectUrl) {
                    projects = projects.toMutableList().apply { this[index] = project.copy(redirectUrl = it) }
                }
            }
        }
        AddButton("+ Add Project") { projects = projects + Project() }

        // --- Skills Section ---
        SectionHeader("Skills")
        skills.forEachIndexed { index, skill ->
            EntityCard(
                onRemove = { skills = skills.filterIndexed { i, _ -> i != index } }
            ) {
                inputField("Skill Name", skill.name) {
                    skills = skills.toMutableList().apply { this[index] = skill.copy(name = it) }
                }
                inputField("Icon URL", skill.iconUrl) {
                    skills = skills.toMutableList().apply { this[index] = skill.copy(iconUrl = it) }
                }
                inputField("Skill Level", skill.skillLevel) {
                    skills = skills.toMutableList().apply { this[index] = skill.copy(skillLevel = it) }
                }
            }
        }
        AddButton("+ Add Skill") { skills = skills + Skill() }

        // --- Socials Section ---
        SectionHeader("Social Links")
        socials.forEachIndexed { index, social ->
            EntityCard(
                onRemove = { socials = socials.filterIndexed { i, _ -> i != index } }
            ) {
                inputField("Platform Name", social.name) {
                    socials = socials.toMutableList().apply { this[index] = social.copy(name = it) }
                }
                inputField("Icon URL", social.iconUrl) {
                    socials = socials.toMutableList().apply { this[index] = social.copy(iconUrl = it) }
                }
                inputField("Redirect URL", social.redirectUrl) {
                    socials = socials.toMutableList().apply { this[index] = social.copy(redirectUrl = it) }
                }
            }
        }
        AddButton("+ Add Social") { socials = socials + Social() }

        Gap(1.cssRem)

        // --- Register Button ---
        Button(
            attrs = {
                style {
                    padding(1.cssRem)
                    backgroundColor(Color("#00AA55"))
                    color(Color.white)
                    borderRadius(8.px)
                    border(width = 0.px)
                    fontSize(1.1.cssRem)
                    cursor("pointer")
                }
                onClick {
                    if (name.isBlank() || email.isBlank()) {
                        message = "⚠️ Please fill in all required fields."
                    } else {
                        val userData = UserData(
                            name = name,
                            role = role,
                            email = email,
                            about = about,
                            country = country,
                            getInTouchDescription = getInTouchDescription,
                            projects = projects,
                            skills = skills,
                            socials = socials
                        )

                        val jsonOutput = Json { prettyPrint = true }.encodeToString(userData)
                        message = "✅ User Data JSON:\n$jsonOutput"
                        scope.launch {
                            writeUserData(userId = userData.hashCode().toString(),userData)

                        }
                    }
                }
            }
        ) { Text("Register") }

        Gap(1.cssRem)

        if (message.isNotBlank()) {
            SpanText(
                text = message,
                modifier = Modifier
                    .fontSize(1.cssRem)
                    .color(if (message.contains("✅")) Colors.LightGreen else Colors.Orange)
            )
        }
    }
}

// --- Helper Composables ---

@Composable
private fun SectionHeader(title: String) {
    SpanText(
        text = title,
        modifier = Modifier
            .fontSize(1.3.cssRem)
            .margin(top = 1.cssRem)
            .color(Colors.LightGray)
    )
}

@Composable
private fun EntityCard(onRemove: () -> Unit, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .backgroundColor(rgba(60, 60, 60, 0.5))
            .padding(1.cssRem)
            .margin(bottom = 0.5.cssRem)
            .borderRadius(8.px)
            .fillMaxWidth()
    ) {
        content()
        Button(
            attrs = {
                style {
                    backgroundColor(Color("#FF5555"))
                    color(Color.white)
                    padding(0.4.cssRem)
                    borderRadius(5.px)
                    fontSize(0.9.cssRem)
                    cursor("pointer")
                    marginTop(0.5.cssRem)
                }
                onClick { onRemove() }
            }
        ) { Text("Remove") }
    }
}

@Composable
private fun AddButton(label: String, onAdd: () -> Unit) {
    Button(
        attrs = {
            style {
                backgroundColor(Color("#0078FF"))
                color(Color.white)
                padding(0.6.cssRem)
                borderRadius(6.px)
                fontSize(1.cssRem)
                cursor("pointer")
                margin(bottom = 1.cssRem)
            }
            onClick { onAdd() }
        }
    ) { Text(label) }
}

@Page("index")
@Composable
fun LandingPage(){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(topBottom = 10.cssRem),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            Div(
                attrs = HeadlineTextStyle.toAttrs()
            ){
                SpanText(
                    text = "Create Your Portfolio",
                    modifier = SectionDiscriptionStyle.toModifier()
                        .textAlign(TextAlign.Center)
                        .fontSize(3.cssRem)
                        .color(
                            when (ColorMode.current) {
                                ColorMode.LIGHT -> Colors.Gray
                                ColorMode.DARK -> Colors.LightGray
                            }
                        )
                )
            }
            Gap(1.cssRem)

            var nameField by remember { mutableStateOf("") }
            var aboutField by remember { mutableStateOf("") }

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.backgroundColor(rgba(39,39,39,0.5))
                    .padding(1.2.cssRem)
                    .margin(topBottom = 0.2.cssRem)
                    .fillMaxWidth()
                    .borderRadius(topLeftAndBottomRight = 10.px, topRightAndBottomLeft = 10.px)
            ) {
                SpanText(
                    text = "Name",
                    modifier = Modifier.textAlign(TextAlign.Start)
                )
                TextInput(
                    text = nameField,
                    onTextChange = {
                        nameField = it
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.backgroundColor(rgba(39,39,39,0.5))
                    .padding(1.2.cssRem)
                    .margin(topBottom = 0.2.cssRem)
                    .fillMaxWidth()
                    .borderRadius(topLeftAndBottomRight = 10.px, topRightAndBottomLeft = 10.px)
            ) {
                SpanText(
                    text = "About you",
                    modifier = Modifier.textAlign(TextAlign.Start)
                )
                TextInput(
                    text = aboutField,
                    onTextChange = {
                        aboutField = it
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

    }
}