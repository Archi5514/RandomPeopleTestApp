package com.example.randompeopletestapp.presentation.main.viewstate

import com.example.randompeopletestapp.core.AppStateEntity
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser
import com.example.randompeopletestapp.domain.entity.appstate.LocalUsersList

data class MainViewState(
    val usersList: LocalUsersList? = null,
    val currentUser: LocalUser? = null
) : AppStateEntity