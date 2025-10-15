package org.app.nocodefolio.components.sections.footer.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.silk.components.icons.fa.*
import org.app.nocodefolio.components.data.UserData
import org.app.nocodefolio.components.sections.home.components.SocialLinkButton
import org.app.nocodefolio.components.utils.Res
import org.jetbrains.compose.web.css.cssRem

@Composable
fun ContactLinksRow(
    displayEmail: Boolean = false,
    userData: UserData
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(1.cssRem),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        if (displayEmail) {
            SocialLinkButton(
                "mailto:"+userData.email
            ) { FaEnvelope(size = IconSize.XXL) }
        }

        val linkedin = userData.socials.find { social -> social.name.lowercase() == "linkedin" }?.redirectUrl
        val discord = userData.socials.find { social -> social.name.lowercase() == "discord" }?.redirectUrl
        val whatsapp = userData.socials.find { social -> social.name.lowercase() == "whatsapp" }?.redirectUrl
        val telegram = userData.socials.find { social -> social.name.lowercase() == "telegram" }?.redirectUrl
        val instagram = userData.socials.find { social -> social.name.lowercase() == "instagram" }?.redirectUrl




        if(linkedin != null)
            SocialLinkButton(
                linkedin
            ) { FaLinkedinIn(size = IconSize.XXL) }

        if(discord != null){
            SocialLinkButton(
                discord
            ) { FaDiscord(size = IconSize.XXL) }

        }

        if (whatsapp != null){
            SocialLinkButton(
                whatsapp
            ) { FaWhatsapp(size = IconSize.XXL) }

        }
        if (telegram!=null){
            SocialLinkButton(
                telegram
            ) { FaTelegram(size = IconSize.XXL) }

        }
       if (instagram != null){
           SocialLinkButton(
               instagram
           ) { FaInstagram(size = IconSize.XXL) }
       }

    }
}