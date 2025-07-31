package org.app.nocodefolio.components.sections.navHeader.components

import androidx.compose.runtime.Composable

@Composable
fun MenuItems(activeSection: String) {
    NavLink("#home", "Home", activeSection == "home")
    NavLink("#about", "About", activeSection == "about")
    NavLink("#projects", "Projects", activeSection == "projects")
    NavLink("#contact", "Contact", activeSection == "contact")
}