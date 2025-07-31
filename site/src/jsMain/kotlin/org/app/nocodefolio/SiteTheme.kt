package org.app.nocodefolio

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.color

/**
 * @property nearBackground A useful color to apply to a container that should differentiate itself from the background
 *   but just a little.
 */
class SitePalette(
    val nearBackground: Color,
    val discription: Color,
    val subHeadLine: Color,
    val buttonBackground: Color,
    val buttonText: Color,

    )

object SitePalettes {
    val light = SitePalette(
        nearBackground = Color.rgb(0xF4F6FA),
        discription = Colors.Gray,
        subHeadLine = Color.rgb(0x0da30d),
        buttonBackground = Colors.Black,
        buttonText = Colors.White,

        )
    val dark = SitePalette(
        nearBackground = Color.rgb(0x454545),
        discription = Colors.LightGray,
        subHeadLine = Color.rgb(0x49D344),
        buttonBackground = Colors.White,
        buttonText = Colors.Black,

        )
}

fun ColorMode.toSitePalette(): SitePalette {
    return when (this) {
        ColorMode.LIGHT -> SitePalettes.light
        ColorMode.DARK -> SitePalettes.dark
    }
}

@InitSilk
fun initTheme(ctx: InitSilkContext) {
    ctx.theme.palettes.light.background = Color.rgb(0xD9D9D9)
    ctx.theme.palettes.light.color = Colors.Black
    ctx.theme.palettes.dark.background = Color.rgb(0x1D1D1D)
    ctx.theme.palettes.dark.color = Colors.White
}

