package org.app.nocodefolio.components.sections.footer.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.icons.fa.FaLocationDot
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.app.nocodefolio.components.sections.footer.style.FooterLocationStyle
import org.app.nocodefolio.components.utils.Res
import org.app.nocodefolio.toSitePalette
import org.jetbrains.compose.web.css.cssRem
import kotlin.js.Date

@Composable
fun DeveloperLocationInfoRow(
    modifier: Modifier = Modifier
) {

    val ctx = rememberPageContext()

    // For Size SM
    Column(
        modifier = modifier
            .fillMaxWidth()
            .displayUntil(Breakpoint.MD),
        verticalArrangement = Arrangement.spacedBy(3.cssRem)
    ) {
        Row (
            modifier = modifier
                .fillMaxWidth()
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){

            Row (
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){

                FaLocationDot(
                    modifier = modifier
                        .padding(right = .5.cssRem)
                        .color(ColorMode.current.toSitePalette().discription)
                    ,
                    size = IconSize.XXS
                )

                SpanText(
                    text = Res.Constants.DEVELOPER_LOCATION,
                    modifier = FooterLocationStyle.toModifier()
                        .onClick {
                            ctx.router.navigateTo(Res.Constants.DEVELOPER_LOCATION_ON_MAP)
                        }
                        .width(6.cssRem)

                )


            }


            TimeDisplay(
                timeZone = "Asia/Kolkata"
            )

        }

        FooterSpanText(
            text = getCopyrightText(),
            modifier = modifier
                .fillMaxWidth()
                .textAlign(TextAlign.Center)
        )
    }


    // For Size MD & Above
    Row (
        modifier = modifier
            .displayIfAtLeast(Breakpoint.MD)
            .fillMaxWidth()
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){

        FooterSpanText(
            text = getCopyrightText(),
            modifier = modifier.fillMaxWidth()
        )


        Row (
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ){

            Row (
                verticalAlignment = Alignment.CenterVertically
            ){

                FaLocationDot(
                    modifier = modifier
                        .padding(right = .5.cssRem)
                        .color(ColorMode.current.toSitePalette().discription)
                    ,
                    size = IconSize.XXS
                )

                SpanText(
                    text = Res.Constants.DEVELOPER_LOCATION,
                    modifier = FooterLocationStyle.toModifier()
                        .onClick {
                            ctx.router.navigateTo(Res.Constants.DEVELOPER_LOCATION_ON_MAP)
                        }

                )

                FooterSpanText(
                    text = "|",
                    modifier = modifier.padding {
                        leftRight(.5.cssRem)
                    }
                )

                TimeDisplay(timeZone = "Asia/Kolkata")
            }

        }
    }
}

@Composable
fun LocationAndTime() {

    Row (
        verticalAlignment = Alignment.CenterVertically
    ){


    }
}


fun getCopyrightText(): String {

    val currentYear = Date().getFullYear().toString()
    return "© $currentYear | ${Res.Constants.COPYRIGHT}"
}
