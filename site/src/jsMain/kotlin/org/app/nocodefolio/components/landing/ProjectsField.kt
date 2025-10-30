package org.app.nocodefolio.components.landing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stevdza.san.kotlinbs.forms.BSInput
import com.stevdza.san.kotlinbs.forms.BSTextArea
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.components.forms.TextInput
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

@Composable
fun ProjectsField(

){
    var projectNameField by mutableStateOf("")
    var projectCoverImageUrlField by mutableStateOf("")
    var projectRedirectUrlField by mutableStateOf("")


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
        TextInput(
            text = projectNameField,
            onTextChange = {
                projectNameField = it
            },
            placeholder = "Project Name",
            modifier = Modifier.fillMaxWidth()
        )
        TextInput(
            text = projectCoverImageUrlField,
            onTextChange = {
                projectCoverImageUrlField = it
            },
            placeholder = "Project Cover Image Url",
            modifier = Modifier.fillMaxWidth()
        )
        TextInput(
            text = projectRedirectUrlField,
            onTextChange = {
                projectRedirectUrlField = it
            },
            placeholder = "Project Url. eg: Github ",
            modifier = Modifier.fillMaxWidth()
        )
    }
}