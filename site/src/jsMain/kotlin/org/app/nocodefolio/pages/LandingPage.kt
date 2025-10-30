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
import com.stevdza.san.kotlinbs.components.BSButton
import com.stevdza.san.kotlinbs.forms.BSInput
import com.stevdza.san.kotlinbs.forms.BSTextArea
import com.stevdza.san.kotlinbs.models.button.ButtonVariant
import com.varabyte.kobweb.compose.css.BackgroundColor
import com.varabyte.kobweb.compose.css.margin
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.InputSize
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
import org.app.nocodefolio.components.landing.ProjectsField
import org.app.nocodefolio.components.landing.ProjectsFieldItem
import org.app.nocodefolio.components.utils.Gap
import org.app.nocodefolio.toSitePalette
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Text
import kotlin.js.iterator


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
    val currentPalette = ColorMode.current.toSitePalette()

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
            var countryField by remember{ mutableStateOf("")}
            var getInTouchDescription by remember{ mutableStateOf("")}
            var emailField by remember { mutableStateOf("") }
            var numberOfProjects by remember { mutableStateOf(0)}

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
                    modifier = Modifier.fillMaxWidth(),
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
                    text = "Name",
                    modifier = Modifier.textAlign(TextAlign.Start)
                )

                TextInput(
                    text = countryField,
                    onTextChange = {
                        countryField = it
                    },
                    modifier = Modifier.fillMaxWidth(),
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
                    text = "email",
                    modifier = Modifier.textAlign(TextAlign.Start)
                )

                TextInput(
                    text = emailField,
                    onTextChange = {
                        emailField = it
                    },
                    modifier = Modifier.fillMaxWidth(),
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
                BSTextArea(
                    value = aboutField,
                    onValueChange = {
                        aboutField = it
                    },
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.transparent)
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
                    text = "Description",
                    modifier = Modifier.textAlign(TextAlign.Start)
                )
                BSTextArea(
                    value = getInTouchDescription,
                    onValueChange = {
                        getInTouchDescription = it
                    },
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.transparent)
                )
            }
            val projects = remember{mutableStateListOf(ProjectsFieldItem())}
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.backgroundColor(rgba(39,39,39,0.5))
                    .padding(1.2.cssRem)
                    .margin(topBottom = 0.2.cssRem)
                    .fillMaxWidth()
                    .borderRadius(topLeftAndBottomRight = 10.px, topRightAndBottomLeft = 10.px)
            ) {
                SpanText(
                    text = "Projects",
                    modifier = Modifier.textAlign(TextAlign.Start)
                )

                projects.forEachIndexed {index: Int,project: ProjectsFieldItem->
                    ProjectsField(project,index)
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(0.5.cssRem)
                ){
                    BSButton(
                        text = "Add",
                        onClick = {
                            projects.add(ProjectsFieldItem())
                        }
                    )
                    BSButton(
                        text = "Remove",
                        onClick = {
                            projects.removeLastOrNull()
                        },
                        variant = ButtonVariant.Secondary,
                        disabled = projects.size <= 1
                    )
                }
            }



        }

    }
}