package com.example.randompeopletestapp.domain.repository

import com.example.randompeopletestapp.domain.entity.appstate.LocalUser
import com.example.randompeopletestapp.domain.entity.RemoteUsersList
import kotlinx.coroutines.Deferred

interface UserRepository {
    fun getRemoteUsersList(resultsCount: Int): Deferred<RemoteUsersList>
    suspend fun insertUser(user: LocalUser)
    suspend fun getLocalUsersList(): List<LocalUser>
}