package com.example.randompeopletestapp.domain.entity

data class RemoteUser(
    val name: Name,
    val location: Location,
    val email: String,
    val login: Login,
    val cell: String,
    val picture: Picture
)

data class Name(
    val title: String,
    val first: String,
    val last: String
)

data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val postcode: String
)

data class Login(
    val uuid: String,
    val username: String,
    val password: String
)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)

data class Street(
    val number: Int,
    val name: String
)