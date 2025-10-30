package org.app.nocodefolio.components.landing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.stevdza.san.kotlinbs.forms.BSInput
import com.stevdza.san.kotlinbs.forms.BSTextArea
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
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
    projectsFieldItem: ProjectsFieldItem,
    index: Int
){

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier//.backgroundColor(rgba(39,39,39,0.5))
            .padding(1.2.cssRem)
            .fillMaxWidth()
            .borderRadius(topLeftAndBottomRight = 10.px, topRightAndBottomLeft = 10.px),
        verticalArrangement = Arrangement.spacedBy(0.8.cssRem)
    ) {
        SpanText(
            text = "Project ${index+1}",
            modifier = Modifier.textAlign(TextAlign.Start)
        )
        TextInput(
            text = projectsFieldItem.projectName,
            onTextChange = {
                projectsFieldItem.projectName = it
            },
            placeholder = "Project Name",
            modifier = Modifier.fillMaxWidth()
        )
        TextInput(
            text = projectsFieldItem.projectImageUrl,
            onTextChange = {
                projectsFieldItem.projectImageUrl = it
            },
            placeholder = "Project Cover Image Url",
            modifier = Modifier.fillMaxWidth()
        )
        TextInput(
            text = projectsFieldItem.projectRedirectUrl,
            onTextChange = {
                projectsFieldItem.projectRedirectUrl = it
            },
            placeholder = "Project Url. eg: Github Repo Url",
            modifier = Modifier.fillMaxWidth()
        )
    }
}
data class ProjectsFieldItem(
    var projectName: String="",
    var projectImageUrl: String="",
    var projectRedirectUrl: String=""
)

