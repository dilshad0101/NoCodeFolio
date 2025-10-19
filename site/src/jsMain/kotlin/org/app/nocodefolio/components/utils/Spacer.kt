package org.app.nocodefolio.components.utils

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.Height
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import org.jetbrains.compose.web.css.cssRem

@Composable
fun Gap(height: CSSLengthOrPercentageNumericValue){
    Box(
        modifier = Modifier.fillMaxWidth()
            .height(height)
    )
}