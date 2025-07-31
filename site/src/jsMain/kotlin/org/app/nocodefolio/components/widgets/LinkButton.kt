package org.app.nocodefolio.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.leftRight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.cssRem

@Composable
fun ThemedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String? = null,
    content: @Composable () -> Unit = {}
) {
    Button(
        onClick = { onClick() },
        modifier = modifier
            .padding { leftRight(0.cssRem) }
        ,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(0.2.cssRem)
        ) {
            content()

            if (!text.isNullOrEmpty()) {
                SpanText(text)
            }
        }
    }
}

@Composable
fun LinkButton(
    path: String,
    modifier: Modifier = Modifier,
    text: String? = null,
    content: @Composable () -> Unit = {}
) {
    val ctx = rememberPageContext()

    ThemedButton(
        onClick = { ctx.router.navigateTo(path) },
        modifier = modifier,
        text = text,
        content = content
    )
}