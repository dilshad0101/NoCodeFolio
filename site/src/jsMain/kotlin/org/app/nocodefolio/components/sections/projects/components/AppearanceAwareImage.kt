package musaib.components.sections.projects.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.ElementRefScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.filter
import org.w3c.dom.HTMLImageElement


@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun AppearanceAwareImage(
    src: String,
    modifier: Modifier = Modifier,
    //variant: ComponentVariant? = null,
    width: Int? = null,
    height: Int? = null,
    alt: String = "",
    ref: ElementRefScope<HTMLImageElement>? = null,
    dyanmicColor: Boolean = true
) {
    val isLight = when (ColorMode.current) {
        ColorMode.LIGHT -> true
        ColorMode.DARK -> false
        }

    Image(
        src = src,
        modifier = modifier.then(
            if (dyanmicColor) {
                Modifier.styleModifier { filter { if (isLight) invert(1) else invert(0) } }
            }
            else Modifier
        ),
        width = width,
        height = height,
        alt = alt,
        ref = ref
    )

}