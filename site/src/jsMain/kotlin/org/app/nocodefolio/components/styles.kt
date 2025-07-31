package org.app.nocodefolio.components

import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.cssRem


val SectionTitleStyle = CssStyle {
    base {
        Modifier
            .fontSize(FontSize.Large)
    }
    Breakpoint.SM {
        Modifier.fontSize(FontSize.Large)
    }
    Breakpoint.MD {
        Modifier.fontSize(FontSize.XLarge)
    }
    Breakpoint.LG {
        Modifier.fontSize(FontSize.XXLarge)
    }
}



val SectionDiscriptionStyle = CssStyle {
    base {
        Modifier.fontSize(FontSize.Medium)
            .margin(topBottom = 0.75.cssRem)

    }
    Breakpoint.SM {
        Modifier.fontSize(FontSize.Small)
            .margin(topBottom = 0.75.cssRem)
    }
    Breakpoint.MD {
        Modifier.fontSize(FontSize.Small)
            .margin(topBottom = 2.cssRem)
    }
    Breakpoint.LG {
        Modifier.fontSize(FontSize.Medium)
            .margin(topBottom = 2.cssRem)
    }

    Breakpoint.XL {
        Modifier.fontSize(FontSize.Large)
            .margin(topBottom = 2.cssRem)
    }
}




