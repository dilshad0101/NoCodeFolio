package org.app.nocodefolio.components.sections.footer.style

import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.extendedBy
import com.varabyte.kobweb.silk.style.selectors.hover
import org.app.nocodefolio.toSitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent

val FooterStyle = CssStyle {
    base {
        Modifier
            .padding(top = 5.cssRem, bottom = 2.cssRem, leftRight = 10.percent)
            .styleModifier {
                backgroundImage(
                    linearGradient(
                        from = colorMode.toSitePalette().subHeadLine,
                        to = colorMode.toSitePalette().nearBackground,
                        dir = LinearGradient.Direction.ToBottom,
                        interpolation = ColorInterpolationMethod.DisplayP3
                    )

                )
            }
    }

}




val FooterTextStyle = CssStyle {

    base {
        Modifier
            .color(colorMode.toSitePalette().discription)
    }



    Breakpoint.ZERO {

        Modifier
            .fontSize(FontSize.Small)
    }

    Breakpoint.SM {

        Modifier
            .fontSize(FontSize.Small)
    }

    Breakpoint.MD {

        Modifier
            .fontSize(FontSize.Large)
    }

    Breakpoint.XL {

        Modifier
            .fontSize(FontSize.Medium)
    }

    Breakpoint.LG {

        Modifier
            .fontSize(FontSize.Medium)
    }

}

val FooterLocationStyle = FooterTextStyle.extendedBy {

    hover {

        Modifier
            .textDecorationLine(TextDecorationLine.Underline)
            .cursor(Cursor.Pointer)
            .onClick {

            }
    }
}


val FooterDescriptionStyle = CssStyle {

    base {
        Modifier
            .textAlign(TextAlign.Justify)
    }

    Breakpoint.ZERO {
        Modifier
            .fontSize(FontSize.Small)
    }

    Breakpoint.SM {
        Modifier
            .fontSize(FontSize.Small)
    }

    Breakpoint.MD {
        Modifier
            .fontSize(FontSize.Large)
    }

    Breakpoint.LG {
        Modifier
            .fontSize(FontSize.Large)
    }

    Breakpoint.XL {
        Modifier
            .fontSize(FontSize.Large)
    }

}

