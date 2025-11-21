package org.app.nocodefolio.components.landing

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.components.forms.TextInput
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.serialization.Serializable
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@Composable
fun ProjectsField(
    project: Project,
    index: Int,
    onProjectNameFieldChange:(String)->Unit,
    onProjectImageUrlFieldChange:(String)-> Unit,
    onProjectRedirectUrlFieldChange:(String) -> Unit
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
            text = "${index+1}. ",
            modifier = Modifier.textAlign(TextAlign.Start)
        )
        TextInput(
            text = project.name,
            onTextChange = {
                onProjectNameFieldChange.invoke(it)
            },
            placeholder = "Project Name",
            modifier = Modifier.fillMaxWidth()
        )
        TextInput(
            text = project.imageUrl,
            onTextChange = {
                onProjectImageUrlFieldChange.invoke(it)
            },
            placeholder = "Project Cover Image Url",
            modifier = Modifier.fillMaxWidth()
        )
        TextInput(
            text = project.redirectUrl,
            onTextChange = {
                onProjectRedirectUrlFieldChange.invoke(it)
            },
            placeholder = "Project Url. eg: Github Repo Url",
            modifier = Modifier.fillMaxWidth()
        )
    }
}
@Serializable
data class Project(
    val name: String="",
    val imageUrl: String="",
    val redirectUrl: String=""
)

