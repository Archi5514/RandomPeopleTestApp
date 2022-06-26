package com.example.randompeopletestapp.domain.entity

import com.example.randompeopletestapp.core.AppStateEntity
import com.example.randompeopletestapp.presentation.main.MainViewState

data class RemoteUsersList(
    val results: List<RemoteUser>
) : MainViewState