package org.app.nocodefolio.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.app.nocodefolio.components.utils.Res
import org.app.nocodefolio.SubheadlineTextStyle
import org.app.nocodefolio.components.SectionTitleStyle

@Composable
fun SectionTitle(
    sectionTitleText: String
) {
    Row {
        Div(SubheadlineTextStyle.toAttrs()) {
            SpanText(
                text = sectionTitleText,
                modifier = SectionTitleStyle.toModifier()
                    .margin(topBottom = 10.cssRem)
                    .padding(right = 1.cssRem)
                    .align(Alignment.Bottom)
                    .color(
                        when (ColorMode.current) {
                            ColorMode.LIGHT -> Colors.Black
                            ColorMode.DARK -> Colors.White
                        }
                    )
                    .fontWeight(FontWeight.Black)
                    .fontFamily("Lexend")
            )
        }

        val portalStar = if (ColorMode.current.isLight) Res.Images.PORTAL_STAR_DARK else Res.Images.PORTAL_STAR_LIGHT

        Image(
            src = portalStar,
            modifier = Modifier
                .align(Alignment.Top)
                .size(22.px)
        )

    }
}