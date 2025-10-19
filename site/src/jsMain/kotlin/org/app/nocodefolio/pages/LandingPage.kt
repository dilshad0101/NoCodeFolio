package org.app.nocodefolio.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.ShapeMargin
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.shapeMargin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.forms.TextInput
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.app.nocodefolio.HeadlineTextStyle
import org.app.nocodefolio.SubheadlineTextStyle
import org.app.nocodefolio.components.SectionDiscriptionStyle
import org.app.nocodefolio.components.utils.Gap
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Div

@Page("index")
@Composable
fun LandingPage(){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(topBottom = 10.cssRem),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            Div(
                attrs = HeadlineTextStyle.toAttrs()
            ){
                SpanText(
                    text = "Create Your Portfolio",
                    modifier = SectionDiscriptionStyle.toModifier()
                        .textAlign(TextAlign.Center)
                        .fontSize(3.cssRem)
                        .color(
                            when (ColorMode.current) {
                                ColorMode.LIGHT -> Colors.Gray
                                ColorMode.DARK -> Colors.LightGray
                            }
                        )
                )
            }
            Gap(1.cssRem)

            var nameField by remember { mutableStateOf("") }
            var aboutField by remember { mutableStateOf("") }
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.backgroundColor(rgba(39,39,39,0.5))
                    .padding(1.2.cssRem)
                    .margin(topBottom = 0.2.cssRem)
                    .fillMaxWidth()
                    .borderRadius(topLeftAndBottomRight = 10.px, topRightAndBottomLeft = 10.px)
            ) {
                SpanText(
                    text = "Name",
                    modifier = Modifier.textAlign(TextAlign.Start)
                )
                TextInput(
                    text = nameField,
                    onTextChange = {
                        nameField = it
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.backgroundColor(rgba(39,39,39,0.5))
                    .padding(1.2.cssRem)
                    .margin(topBottom = 0.2.cssRem)
                    .fillMaxWidth()
                    .borderRadius(topLeftAndBottomRight = 10.px, topRightAndBottomLeft = 10.px)
            ) {
                SpanText(
                    text = "About you",
                    modifier = Modifier.textAlign(TextAlign.Start)
                )
                TextInput(
                    text = aboutField,
                    onTextChange = {
                        aboutField = it
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

    }
}