package com.example.randompeopletestapp.domain.entity.appstate

import com.example.randompeopletestapp.presentation.main.viewstate.MainViewState

data class LocalUsersList(val usersList: List<LocalUser>) : MainViewState
