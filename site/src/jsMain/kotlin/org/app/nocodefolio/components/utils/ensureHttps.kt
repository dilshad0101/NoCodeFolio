package org.app.nocodefolio.components.utils

fun ensureHttps(url: String): String {
    return when {
        url.startsWith("mailto:", ignoreCase = true) -> url       // leave as-is
        url.startsWith("http://") || url.startsWith("https://") -> url
        else -> "https://$url"
    }
}