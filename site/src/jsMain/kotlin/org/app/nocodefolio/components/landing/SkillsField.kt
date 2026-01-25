package org.app.nocodefolio.components.landing

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.components.forms.TextInput
import com.varabyte.kobweb.silk.components.text.SpanText
import kotlinx.serialization.Serializable
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

@Composable
fun SkillsField(
    skill: Skill,
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
            text = skill.name,
            onTextChange = {
                onSkillNameFieldChange.invoke(it)
            },
            placeholder = "Skill eg: HTML/CSS",
            modifier = Modifier.fillMaxWidth()
                .color(Color.white)
                .border(
                    width = 1.px,
                    style = LineStyle.Solid,
                    color = rgba(242, 242, 242, 0.3)
                )
        )
        TextInput(
            text = skill.iconUrl,
            onTextChange = {
                onSkillIconUrlFieldChange.invoke(it)
            },
            placeholder = "Icon Url eg: Url to Logo of CSS",
            modifier = Modifier.fillMaxWidth()
                .color(Color.white)
                .border(
                    width = 1.px,
                    style = LineStyle.Solid,
                    color = rgba(242, 242, 242, 0.3)
                )
        )
        TextInput(
            text = skill.skillLevel,
            onTextChange = {
                onSkillLevelFieldChange.invoke(it)
            },
            placeholder = "Level of Proficiency eg: Expert, Basic",
            modifier = Modifier.fillMaxWidth()
                .color(Color.white)
                .border(
                    width = 1.px,
                    style = LineStyle.Solid,
                    color = rgba(242, 242, 242, 0.3)
                )
        )
    }
}
@Serializable
data class Skill(
    val name: String="",
    val iconUrl: String="",
    val skillLevel: String=""
)