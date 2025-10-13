package org.app.nocodefolio.components.sections.home.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.app.nocodefolio.components.data.UserData
import org.app.nocodefolio.components.styles.SocialLinkStyle
import org.app.nocodefolio.components.utils.Res
import org.app.nocodefolio.components.widgets.LinkButton
import org.jetbrains.compose.web.css.cssRem

@Composable
fun SocialLinksRow(
    breakpoint: Breakpoint,
    userData: UserData
) {

    // In Case we Dynamic Padding
    val bottomPadding = when (breakpoint) {
        Breakpoint.ZERO, Breakpoint.SM, Breakpoint.MD -> 3.cssRem
        else -> 3.cssRem
    }

    val spaceBetweenIcons = when (breakpoint) {
        Breakpoint.ZERO, Breakpoint.SM, Breakpoint.MD -> 1.5.cssRem
        else -> 2.5.cssRem
    }
    Row(
        modifier = Modifier
            .padding {
                top(1.cssRem)
                bottom(bottomPadding)
                     },
        horizontalArrangement = Arrangement.spacedBy(spaceBetweenIcons),
        verticalAlignment = Alignment.CenterVertically
    ){

        val linkedin = userData.socials.find { social -> social.name.lowercase() == "linkedin" }?.redirectUrl
        val discord = userData.socials.find { social -> social.name.lowercase() == "discord" }?.redirectUrl
        val whatsapp = userData.socials.find { social -> social.name.lowercase() == "whatsapp" }?.redirectUrl
        val telegram = userData.socials.find { social -> social.name.lowercase() == "telegram" }?.redirectUrl
        val instagram = userData.socials.find { social -> social.name.lowercase() == "instagram" }?.redirectUrl
        val github = userData.socials.find { social -> social.name.lowercase() == "github" }?.redirectUrl
        val twitter = userData.socials.find { social -> social.name.lowercase() == "twitter" }?.redirectUrl
        val hackerrank = userData.socials.find { social -> social.name.lowercase() == "hackerrank" }?.redirectUrl
        val medium = userData.socials.find { social -> social.name.lowercase() == "medium" }?.redirectUrl






        // In Case Need Dynamic Sizes for Icons
        val iconSize = when (breakpoint) {
            Breakpoint.ZERO, Breakpoint.SM, Breakpoint.MD -> IconSize.X3
            else -> IconSize.X3
        }

        linkedin?.let {
            SocialLinkButton(
                it
            ) { FaLinkedin(size = iconSize) }
        }

        github?.let {
            SocialLinkButton(
                it
            ) { FaGithub(size = iconSize) }
        }

        twitter?.let {
            SocialLinkButton(
                it

            ) { FaXTwitter(size = iconSize) }
        }

        hackerrank?.let {
            SocialLinkButton(
                it
            ) { FaHackerrank(size = iconSize) }
        }

        medium?.let {
            SocialLinkButton(
                it
            ) { FaMedium(size = iconSize) }
        }

    }
}

@Composable
internal fun SocialLinkButton(
    url: String,
    icon: @Composable () -> Unit
) {
    LinkButton(
        url,
        modifier =  SocialLinkStyle.toModifier()
            .color(
            when (ColorMode.current) {
                ColorMode.LIGHT -> Colors.Black
                ColorMode.DARK -> Colors.White
            }
        )
            .backgroundColor(
                when (ColorMode.current) {
                    ColorMode.LIGHT -> Colors.Transparent
                    ColorMode.DARK -> Colors.Transparent
                }
            )
    ) {
        icon()
    }
}


