package org.app.nocodefolio.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.browser.util.kebabCaseToCamelCase
import com.varabyte.kobweb.browser.util.kebabCaseToTitleCamelCase
import com.varabyte.kobweb.browser.util.titleCamelCaseToKebabCase
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import dev.bitspittle.firebase.auth.User
import kotlinx.browser.document
import org.app.nocodefolio.components.sections.footer.ui.Footer
import musaib.components.sections.navHeader.ui.NavHeader
import org.app.nocodefolio.components.data.UserData
import org.app.nocodefolio.components.data.readUserData
import org.app.nocodefolio.components.utils.Res
import org.app.nocodefolio.components.widgets.SVGHeroBackround
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Text

@Composable
fun DefaultPageLayout(
    userName: String,
    content: @Composable (UserData) -> Unit,
) {
    var isUser: UserData? by remember{ mutableStateOf(null) }
    LaunchedEffect(userName) {
        document.title = userName.kebabCaseToTitleCamelCase()
        isUser = readUserData(userName)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .position(Position.Relative)
            .gridTemplateRows { size(1.fr); size(minContent) },

        ) {
        if (isUser != null){

            // For Display Size Until MD
            SVGHeroBackround(
                modifier = Modifier
                    .displayUntil(Breakpoint.MD)
                    .top((-50).px)
                    .left((-50).px)
                    .height(28.vh)

                ,
                src = Res.Images.GREEN_CIRCE
            )

            // For Display Size After  MD
            SVGHeroBackround(
                modifier = Modifier
                    .displayIfAtLeast(Breakpoint.LG)
                    .top(0.px)
                    .right(0.px)
                    .height(100.vh)
                ,
                src = Res.Images.WAVES
            )

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NavHeader()
                content(isUser!!)
                Footer(userData = isUser!!)

            }
        }else{
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text("Loading Content..")
            }
        }
    }
}