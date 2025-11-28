package org.app.nocodefolio.pages.components

import androidx.compose.runtime.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.attributes.*

@Composable
fun DismissibleAlert(
    message: String,
    linkText: String,
    linkUrl: String,
    modifier: String = "",
    onDismiss: (() -> Unit)? = null
) {
    var visible by remember { mutableStateOf(true) }
    if (!visible) return

    Div(attrs = {
        classes("kob-alert-container")
        if (modifier.isNotBlank()) classes(modifier)
        style {
            property("display", "flex")
            property("align-items", "center")
            property("justify-content", "space-between")
            property("gap", "12px")
            property("padding", "12px 16px")
            property("border-radius", "8px")
            property("box-shadow", "0 2px 6px rgba(0,0,0,0.08)")
            property("background-color", "#e6ffed") // light success green
            property("color", "#0a4d2a")
        }
    }) {
        // left: message + link
        Div(attrs = {
            style {
                property("display", "flex")
                property("flex-direction", "column")
            }
        }) {
            Span {
                Text(message)
            }
            A(href = linkUrl, attrs = {
                target(ATarget.Blank)
                attr("rel","noopener noreferrer")
                style {
                    property("margin-top", "6px")
                    property("text-decoration", "underline")
                }
            }) {
                Text(linkText)
            }
        }

        // right: dismiss button
        Button(attrs = {
            onClick { visible = false; onDismiss?.invoke() }
            style {
                property("background", "transparent")
                property("border", "none")
                property("cursor", "pointer")
                property("font-weight", "600")
                property("padding", "6px")
            }
            title("Dismiss")
            attr("label", "Dismiss alert")
        }) {
            Text("✕")
        }
    }
}

fun injectAlertStyles() {
    val css = """
    .kob-alert-container:hover { transform: translateY(-1px); transition: transform 120ms ease; }
    @media (max-width: 600px) {
      .kob-alert-container { flex-direction: column; align-items: flex-start; }
    }
    """
    kotlinx.browser.document.head?.appendChild(kotlinx.browser.document.createElement("style")).also { el ->
        (el as? org.w3c.dom.HTMLStyleElement)?.textContent = css
    }
}

