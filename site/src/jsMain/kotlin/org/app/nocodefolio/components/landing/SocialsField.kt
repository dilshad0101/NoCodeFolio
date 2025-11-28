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
fun SocialsField(
    social: Social,
    index: Int,
    onSocialNameFieldChange:(String) ->Unit,
    onSocialIconUrlFieldChange:(String) -> Unit,
    onSocialRedirectUrlFieldChange:(String) -> Unit
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
            text = social.name,
            onTextChange = {
                onSocialNameFieldChange.invoke(it)
            },
            placeholder = "Social eg: Linkedin",
            modifier = Modifier.fillMaxWidth()
        )
        TextInput(
            text = social.iconUrl,
            onTextChange = {
                onSocialIconUrlFieldChange.invoke(it)
            },
            placeholder = "Icon Url eg: Url to Logo of Twitter",
            modifier = Modifier.fillMaxWidth()
        )
        TextInput(
            text = social.redirectUrl,
            onTextChange = {
                onSocialRedirectUrlFieldChange.invoke(it)
            },
            placeholder = "Profile Url",
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Serializable
data class Social(
    val name: String = "",
    val iconUrl: String = "",
    val redirectUrl: String = ""
)

@Serializable
data class ActionButton(
    val buttonText: String = "",
    val buttonRedirectUrl: String = ""
)