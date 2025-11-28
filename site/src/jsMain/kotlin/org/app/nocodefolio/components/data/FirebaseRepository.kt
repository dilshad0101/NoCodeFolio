package org.app.nocodefolio.components.data

import dev.bitspittle.firebase.database.value
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.app.nocodefolio.components.landing.ActionButton
import org.app.nocodefolio.components.landing.Project
import org.app.nocodefolio.components.landing.Skill
import org.app.nocodefolio.components.landing.Social


suspend fun writeUserData(userId: String,user: UserData) {
    val db = app.getDatabase()
    val jsonStr = Json.encodeToString(user)
    val jsonObj = JSON.parse<dynamic>(jsonStr)
    db.ref("users/$userId").set(jsonObj)
}
suspend fun readUserData(path: String): UserData?{

    val data = app.getDatabase().ref("users/$path").get().value()
    val json = JSON.stringify(data)
    return Json.decodeFromString(json)
}


@Serializable
data class UserData(
    val name: String = "",
    val role: String = "",
    val email: String = "",
    val about: String = "",
    val socials: List<Social> = emptyList(),
    val skills: List<Skill> = emptyList(),
    val projects: List<Project> = emptyList(),
    val getInTouchDescription:String = "",
    val country: String = "",
    val actionButton: ActionButton = ActionButton(
        buttonText = "",
        buttonRedirectUrl = ""
    )

)



