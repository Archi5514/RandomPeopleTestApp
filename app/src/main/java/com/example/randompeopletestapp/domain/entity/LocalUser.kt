package com.example.randompeopletestapp.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.randompeopletestapp.core.AppStateEntity

@Entity(tableName = "users_table")
data class LocalUser(
    @PrimaryKey(autoGenerate = false)
    val uuid: String,
    val gender: String,
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
    val age: Int,
    val cell: String,
    val largePic: String,
    val mediumPic: String,
    val thumbnailPic: String
) : AppStateEntity {

    companion object {
        fun fromRemote(remoteUser: RemoteUser) =
            LocalUser(
                uuid = remoteUser.login.uuid,
                gender = remoteUser.gender,
                title = remoteUser.name.title,
                first = remoteUser.name.first,
                last = remoteUser.name.last,
                street = remoteUser.location.street,
                city = remoteUser.location.city,
                state = remoteUser.location.state,
                postcode = remoteUser.location.postcode,
                email = remoteUser.email,
                username = remoteUser.login.username,
                password = remoteUser.login.password,
                age = remoteUser.dob.age,
                cell = remoteUser.cell,
                largePic = remoteUser.picture.large,
                mediumPic = remoteUser.picture.medium,
                thumbnailPic = remoteUser.picture.thumbnail
            )
    }

}