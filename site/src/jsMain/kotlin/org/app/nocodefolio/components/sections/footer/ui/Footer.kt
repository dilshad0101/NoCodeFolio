package org.app.nocodefolio.components.sections.footer.ui

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.style.toModifier
import org.app.nocodefolio.components.data.UserData
import org.app.nocodefolio.components.sections.footer.components.DeveloperLocationInfoRow
import org.app.nocodefolio.components.sections.footer.components.FooterContactRow
import org.app.nocodefolio.components.sections.footer.components.GetInTouchColumn
import org.app.nocodefolio.components.sections.footer.style.FooterStyle
import org.jetbrains.compose.web.css.cssRem


@Composable
fun Footer(
    modifier: Modifier = Modifier,
    userData: UserData
) {
    Column (
        modifier = FooterStyle.toModifier()
            .fillMaxWidth()
            .id("contact")


    ){

        Column(
            modifier = modifier
                .fillMaxWidth()

        ) {

            GetInTouchColumn()

            FooterContactRow(
                modifier = modifier.padding { bottom(4.cssRem) },
                userData = userData)

            DeveloperLocationInfoRow()
        }




    }
}











