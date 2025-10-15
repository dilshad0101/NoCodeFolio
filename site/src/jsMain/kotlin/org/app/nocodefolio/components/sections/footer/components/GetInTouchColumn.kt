package org.app.nocodefolio.components.sections.footer.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toModifier
import org.app.nocodefolio.components.data.UserData
import org.app.nocodefolio.components.sections.footer.style.FooterDescriptionStyle
import org.app.nocodefolio.components.utils.Res
import org.jetbrains.compose.web.css.cssRem

@Composable
fun GetInTouchColumn(
    modifier: Modifier = Modifier,
    userData: UserData
                     ) {

    Column (
        modifier = modifier
            .fillMaxWidth()
        ,
        horizontalAlignment = Alignment.Start
    ){

        // Get in Touch
        Row (
            modifier = modifier.fillMaxWidth()
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){

            SpanText(
                text = Res.Constants.GET_IN_TOUCH,
                modifier = modifier
                    .fontSize(2.cssRem)
                    .fontWeight(FontWeight.Black)
            )
        }

        // Discription

        // For Size SM & Below
        Column (
            modifier = modifier
                .displayUntil(Breakpoint.MD)
                .fillMaxWidth()
                .padding(top = 1.cssRem, bottom = 3.cssRem)
            ,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {

            SpanText(
                text = userData.getInTouchDescription,
                modifier = FooterDescriptionStyle.toModifier()
            )
        }

        // For Size MD & Above
        Column (
            modifier = modifier
                .displayIfAtLeast(Breakpoint.MD)
                .width(52.cssRem)
                .padding(top = 1.cssRem, bottom = 3.cssRem)
            ,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {

            SpanText(
                text = userData.getInTouchDescription,
                modifier = FooterDescriptionStyle.toModifier()
            )

        }
    }
}