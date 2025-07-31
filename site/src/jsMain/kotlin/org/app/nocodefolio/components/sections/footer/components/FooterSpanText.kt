package org.app.nocodefolio.components.sections.footer.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.app.nocodefolio.components.sections.footer.style.FooterTextStyle

@Composable
fun FooterSpanText(text: String, modifier: Modifier = Modifier) {
    SpanText(
        text = text,
        modifier = FooterTextStyle.toModifier().then(modifier)

            .color(
                when (ColorMode.current) {
                    ColorMode.LIGHT -> Colors.Gray
                    ColorMode.DARK -> Colors.LightGray
                }
            )
    )
}
