package org.app.nocodefolio.components.sections.about.ui

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.app.nocodefolio.components.data.UserData
import org.app.nocodefolio.components.sections.about.components.SkillItem
import org.app.nocodefolio.components.sections.about.style.AboutDiscriptionStyle
import org.app.nocodefolio.components.sections.about.style.AboutStyle
import org.app.nocodefolio.components.sections.about.style.SkillsGridStyle
import org.app.nocodefolio.components.utils.Res
import org.app.nocodefolio.components.widgets.SectionTitle

@Composable
fun About(
    userData: UserData
) {
    Column (
        modifier = AboutStyle.toModifier().id("about"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){


        SectionTitle(Res.Title.ABOUT)

        SpanText(
            text = userData.about,
            modifier = AboutDiscriptionStyle.toModifier()
                .color(
                    when (ColorMode.current) {
                        ColorMode.LIGHT -> Colors.Gray
                        ColorMode.DARK -> Colors.LightGray
                    }
                )
                .lineHeight(2)

        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            SimpleGrid(
                modifier = SkillsGridStyle.toModifier()
                ,
                numColumns = numColumns(base = 2, md = 5, lg = 5)
            ) {
                userData.skills.forEach { skill ->
                    SkillItem(
                        skill = skill,
                    )
                }
            }
        }

    }
}
