package com.example.randompeopletestapp.data.worker

import com.example.randompeopletestapp.domain.entity.appstate.LocalUser
import com.example.randompeopletestapp.domain.repository.UserRepository

class DatabaseUpdater(private val repository: UserRepository) : UsersUpdateReceiver {
    override suspend fun updateReceived(users: List<LocalUser>) {
        users.forEach { repository.insertUser(it) }
    }
}