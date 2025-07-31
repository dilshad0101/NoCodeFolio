package musaib.components.sections.navHeader.styles

import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.css.functions.saturate
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backdropFilter
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val NavHeaderStyle = CssStyle.base {
    val colorPalette = colorMode.toPalette()
    Modifier
        .fillMaxWidth()
        .padding(1.cssRem)
        .backgroundColor(colorPalette.background.toRgb().copyf(alpha = 0.8f))
        .position(Position.Sticky)
        .top(0.percent)
        .backdropFilter(saturate(180.percent), blur(8.px))
        .display(DisplayStyle.Flex)
}

val SideMenuStyle = CssStyle.base {

    val colorPalette = colorMode.toPalette()
    Modifier
        .fillMaxHeight()
        .width(clamp(8.cssRem, 33.percent, 10.cssRem))
        .padding(top = 1.cssRem, leftRight = 1.cssRem)
        .gap(1.5.cssRem)
        .backgroundColor(colorPalette.background.toRgb().copyf(alpha = 0.8f))
        .backdropFilter(saturate(180.percent), blur(8.px))
}

val MenuStyle = CssStyle{

    hover {
        Modifier.opacity(.5)
    }
}

val SideMenuSlideInAnim = Keyframes {
    from {
        Modifier.translateX((-100).percent)
    }

    to {
        Modifier
    }
}