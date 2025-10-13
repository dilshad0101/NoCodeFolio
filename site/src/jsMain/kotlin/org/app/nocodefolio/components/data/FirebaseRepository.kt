package org.app.nocodefolio.components.data

import dev.bitspittle.firebase.database.value
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


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
    val projects: List<Project> = emptyList()
)

@Serializable
data class Project(
    val name: String = "",
    val imageUrl: String = "",
    val redirectUrl: String = ""
)

@Serializable
data class Skill(
    val name: String = "",
    val iconUrl: String = "",
    val skillLevel: String = ""
)

@Serializable
data class Social(
    val name: String = "",
    val iconUrl: String = "",
    val redirectUrl: String = ""
)

