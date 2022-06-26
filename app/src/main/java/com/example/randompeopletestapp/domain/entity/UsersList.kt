package com.example.randompeopletestapp.domain.entity

import com.example.randompeopletestapp.core.AppStateEntity

data class UsersList(
    val results: List<User>
) : AppStateEntity