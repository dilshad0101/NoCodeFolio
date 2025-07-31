package org.app.nocodefolio.components.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.silk.components.forms.ButtonKind
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.style.CssStyleVariant
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.selectors.hover

object ButtonColors {

    val NormalButton: CssStyleVariant<ButtonKind> = ButtonStyle.addVariant {
        base {
            Modifier
                .backgroundColor(Colors.White)
        }
        hover {
            Modifier
                .backgroundColor(Colors.White.copyf(23f))
        }
    }
}
