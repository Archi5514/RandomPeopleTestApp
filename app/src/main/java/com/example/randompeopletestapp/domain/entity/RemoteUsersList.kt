package com.example.randompeopletestapp.domain.entity

import com.example.randompeopletestapp.core.AppStateEntity

data class RemoteUsersList(
    val results: List<RemoteUser>
) : AppStateEntity