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
) : AppStateEntity