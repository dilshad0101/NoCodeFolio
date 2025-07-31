package musaib.components.sections.navHeader.ui

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.document
import kotlinx.browser.window
import org.app.nocodefolio.components.sections.navHeader.components.ColorModeButton
import org.app.nocodefolio.components.sections.navHeader.components.HamburgerButton
import org.app.nocodefolio.components.sections.navHeader.components.MenuItems
import org.app.nocodefolio.components.sections.navHeader.components.SideMenu
import musaib.components.sections.navHeader.styles.NavHeaderStyle
import org.jetbrains.compose.web.css.cssRem

// Note: When the user closes the side menu, we don't immediately stop rendering it (at which point it would disappear
// abruptly). Instead, we start animating it out and only stop rendering it when the animation is complete.


enum class SideMenuState {
    CLOSED,
    OPEN,
    CLOSING;

    fun close() = when (this) {
        CLOSED -> CLOSED
        OPEN -> CLOSING
        CLOSING -> CLOSING
    }
}


@Composable
fun NavHeader() {
    var activeSection by remember { mutableStateOf("home") }

    // Side effect to listen to scroll events and update active section
    SideEffect {
        window.onscroll =  {
            val sections = listOf("home", "about", "projects", "contact")
            sections.forEach { section ->
                val element = document.getElementById(section)
                if (element != null) {
                    val rect = element.getBoundingClientRect()
                    if (rect.top <= window.innerHeight / 2 && rect.bottom >= window.innerHeight / 2) {
                        activeSection = section
                    }
                }
            }
        }
    }

    Row(
        NavHeaderStyle.toModifier(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .gap(1.5.cssRem)
                .displayIfAtLeast(Breakpoint.MD),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            MenuItems(activeSection)
        }

        Row(
            Modifier
                .gap(1.5.cssRem)
                .displayIfAtLeast(Breakpoint.MD),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            ColorModeButton()
        }

        Row(
            Modifier
                .fillMaxWidth()
                .fontSize(1.5.cssRem)
                .gap(1.cssRem)
                .displayUntil(Breakpoint.MD),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            var menuState by remember { mutableStateOf(SideMenuState.CLOSED) }

            HamburgerButton(onClick = { menuState = SideMenuState.OPEN })

            if (menuState != SideMenuState.CLOSED) {
                SideMenu(
                    menuState,
                    activeSection = activeSection,
                    close = { menuState = menuState.close() },
                    onAnimationEnd = { if (menuState == SideMenuState.CLOSING) menuState = SideMenuState.CLOSED }
                )
            }

            ColorModeButton()
        }
    }
}


