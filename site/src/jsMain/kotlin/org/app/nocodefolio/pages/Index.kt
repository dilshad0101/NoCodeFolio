package org.app.nocodefolio.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.app.nocodefolio.components.sections.about.ui.About
import org.app.nocodefolio.components.sections.home.ui.Home
import musaib.components.sections.projects.ui.Projects
import org.app.nocodefolio.components.layouts.DefaultPageLayout
import org.app.nocodefolio.toSitePalette

@Page("{user}")
@Composable
fun HomePage(ctx: PageContext) {
    val userName = ctx.route.params["user"].toString()
    DefaultPageLayout(
        userName = userName
        ) { userData ->

        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            val currentPalette = ColorMode.current.toSitePalette()


            Home(currentPalette = currentPalette, userData = userData)

            About(userData = userData)

            Projects(userData = userData)
        }
    }

}

