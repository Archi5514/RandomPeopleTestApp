package com.example.randompeopletestapp.domain.entity.appstate

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.randompeopletestapp.domain.entity.RemoteUser
import com.example.randompeopletestapp.presentation.main.viewstate.MainViewState

@Entity(tableName = "users_table")
data class LocalUser(
    @PrimaryKey(autoGenerate = false)
    val uuid: String,
    val title: String,
    val first: String,
    val last: String,
    val street: String,
    val city: String,
    val state: String,
    val postcode: String,
    val email: String,
    val username: String,
    val password: String,
    val cell: String,
    val largePic: String,
    val mediumPic: String,
    val thumbnailPic: String
) {

    companion object {
        fun fromRemote(remoteUser: RemoteUser) =
            LocalUser(
                uuid = remoteUser.login.uuid,
                title = remoteUser.name.title,
                first = remoteUser.name.first,
                last = remoteUser.name.last,
                street = remoteUser.location.street.run {
                    return@run "$number ${if (address == "null") "" else address}"
                },
                city = remoteUser.location.city,
                state = remoteUser.location.state,
                postcode = remoteUser.location.postcode,
                email = remoteUser.email,
                username = remoteUser.login.username,
                password = remoteUser.login.password,
                cell = remoteUser.cell,
                largePic = remoteUser.picture.large,
                mediumPic = remoteUser.picture.medium,
                thumbnailPic = remoteUser.picture.thumbnail
            )
    }

}