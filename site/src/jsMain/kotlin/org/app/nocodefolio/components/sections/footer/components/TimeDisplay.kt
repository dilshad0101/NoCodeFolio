package org.app.nocodefolio.components.sections.footer.components

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.alignContent
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.coroutines.delay
import org.app.nocodefolio.components.sections.footer.style.FooterTextStyle
import org.jetbrains.compose.web.css.AlignContent
import org.jetbrains.compose.web.css.cssRem
import kotlin.js.Date
import kotlin.time.Duration.Companion.seconds

@Composable
fun TimeDisplay(
    modifier: Modifier = Modifier,
    timeZone: String
) {

    var currentTime by remember { mutableStateOf(getFormattedTime(timeZone)) }

    LaunchedEffect(Unit) {
        while (true) {
            currentTime = getFormattedTime(timeZone)
            delay(1.seconds)
        }
    }

    SpanText(
        text = currentTime,
        modifier = FooterTextStyle.toModifier().then(modifier)
            .width(5.cssRem)
            .alignContent(AlignContent.End)
            .color(
                when (ColorMode.current) {
                    ColorMode.LIGHT -> Colors.Gray
                    ColorMode.DARK -> Colors.LightGray
                }
            )
    )
}

// Function to get the formatted time for a specific time zone
fun getFormattedTime(timeZone: String): String {
    val options = js("{ timeZone: timeZone, hour: '2-digit', minute: '2-digit', hour12: true }")
    return Date().toLocaleTimeString("en-US", options)
}
