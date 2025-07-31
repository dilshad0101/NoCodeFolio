package org.app.nocodefolio.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.PointerEvents
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.pointerEvents
import com.varabyte.kobweb.compose.ui.modifiers.position
import musaib.components.sections.projects.components.AppearanceAwareImage
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.Position

@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun SVGHeroBackround(
    modifier: Modifier = Modifier,
    src: String
) {
    AppearanceAwareImage(
        src = src,
        dyanmicColor = false,
        modifier = modifier.then(modifier)
            .position(Position.Absolute)
            .pointerEvents(PointerEvents.None)
    )
}