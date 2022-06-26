package com.example.randompeopletestapp.domain.repository

import com.example.randompeopletestapp.domain.entity.LocalUser
import com.example.randompeopletestapp.domain.entity.RemoteUsersList
import kotlinx.coroutines.Deferred

interface UserRepository {
    suspend fun getRemoteUsersList(resultsCount: Int): RemoteUsersList
    suspend fun insertUser(user: LocalUser)
    suspend fun getLocalUsersList(): List<LocalUser>
}