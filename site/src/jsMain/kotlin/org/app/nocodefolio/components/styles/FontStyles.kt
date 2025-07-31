package org.app.nocodefolio.components.styles

import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint


val SkillTextStyle = CssStyle{

    base {
        Modifier
            .fontWeight(FontWeight.Medium)
    }
    Breakpoint.ZERO {

        Modifier.fontSize(FontSize.Small)
    }
    Breakpoint.SM {
        Modifier.fontSize(FontSize.Small)
    }
    Breakpoint.MD {
        Modifier.fontSize(FontSize.Medium)
    }
    Breakpoint.LG {
        Modifier.fontSize(FontSize.Medium)
    }
    Breakpoint.XL {
        Modifier.fontSize(FontSize.Large)
    }


}

val SkillProficiencyTextStyle = CssStyle {


    Breakpoint.ZERO {

        Modifier.fontSize(FontSize.XSmall)
    }
    Breakpoint.SM {
        Modifier.fontSize(FontSize.XSmall)
    }
    Breakpoint.MD {
        Modifier.fontSize(FontSize.Small)
    }
    Breakpoint.LG {
        Modifier.fontSize(FontSize.Medium)
    }
    Breakpoint.XL {
        Modifier.fontSize(FontSize.Medium)
    }
}

