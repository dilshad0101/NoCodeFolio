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
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@Composable
fun SkillsField(
    skillFieldItem: SkillFieldItem,
    index: Int,
    onSkillNameFieldChange:(String) ->Unit,
    onSkillLevelFieldChange:(String) -> Unit,
    onSkillIconUrlFieldChange:(String) -> Unit
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
            text = skillFieldItem.skillName,
            onTextChange = {
                onSkillNameFieldChange.invoke(it)
            },
            placeholder = "Skill eg: HTML/CSS",
            modifier = Modifier.fillMaxWidth()
        )
        TextInput(
            text = skillFieldItem.skillIconUrl,
            onTextChange = {
                onSkillIconUrlFieldChange.invoke(it)
            },
            placeholder = "Icon Url eg: Url to Logo of CSS",
            modifier = Modifier.fillMaxWidth()
        )
        TextInput(
            text = skillFieldItem.skillLevel,
            onTextChange = {
                onSkillLevelFieldChange.invoke(it)
            },
            placeholder = "Level of Proficiency eg: Expert, Basic",
            modifier = Modifier.fillMaxWidth()
        )
    }
}
data class SkillFieldItem(
    val skillName: String="",
    val skillIconUrl: String="",
    val skillLevel: String=""
)