package org.app.nocodefolio.components.sections.navHeader.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.silk.components.icons.HamburgerIcon
import org.app.nocodefolio.components.widgets.IconButton

@Composable
fun HamburgerButton(onClick: () -> Unit) {
    IconButton(onClick) {
        HamburgerIcon()
    }
}