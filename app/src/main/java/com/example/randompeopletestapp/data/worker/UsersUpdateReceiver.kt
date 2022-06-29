package com.example.randompeopletestapp.data.worker

import com.example.randompeopletestapp.domain.entity.appstate.LocalUser

interface UsersUpdateReceiver {
    suspend fun updateReceived(users: List<LocalUser>)
}