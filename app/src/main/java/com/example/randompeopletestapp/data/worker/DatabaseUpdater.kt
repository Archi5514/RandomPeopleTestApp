package com.example.randompeopletestapp.data.worker

import com.example.randompeopletestapp.data.dto.local.UserDao
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser

class DatabaseUpdater(private val dao: UserDao) : UsersUpdateReceiver {
    override suspend fun updateReceived(users: List<LocalUser>) {
        users.forEach { dao.insertUser(it) }
    }
}