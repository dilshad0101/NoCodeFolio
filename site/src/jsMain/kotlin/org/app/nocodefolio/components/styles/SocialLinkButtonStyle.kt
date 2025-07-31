package org.app.nocodefolio.components.styles

import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.ms

val SocialLinkStyle = CssStyle {

    base {
        Modifier.scale(1).transition(
            transition = Transition.of(
                property = TransitionProperty.All,
                duration = 500.ms
            ),
        )
    }
    hover {
        Modifier.scale(1.3)
    }
}
