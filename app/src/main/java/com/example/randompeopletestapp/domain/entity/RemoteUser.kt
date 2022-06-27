package com.example.randompeopletestapp.domain.entity

data class RemoteUser(
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val login: Login,
    val dob: Dob,
    val cell: String,
    val picture: Picture
)

data class Name(
    val title: String,
    val first: String,
    val last: String
)

data class Location(
    val street: String,
    val city: String,
    val state: String,
    val postcode: String
)

data class Login(
    val uuid: String,
    val username: String,
    val password: String
)

data class Dob(
    val age: Int
)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)