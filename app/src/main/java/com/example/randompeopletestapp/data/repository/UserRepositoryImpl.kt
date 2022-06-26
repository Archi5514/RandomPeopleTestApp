package com.example.randompeopletestapp.data.repository

import com.example.randompeopletestapp.data.dto.local.UserDatabase
import com.example.randompeopletestapp.data.dto.remote.ApiDataSource
import com.example.randompeopletestapp.domain.entity.LocalUser
import com.example.randompeopletestapp.domain.entity.RemoteUsersList
import com.example.randompeopletestapp.domain.repository.UserRepository
import kotlinx.coroutines.Deferred

class UserRepositoryImpl(
    private val apiDataSource: ApiDataSource,
    userDatabase: UserDatabase
) : UserRepository {

    private val userDao = userDatabase.getDao()

    override suspend fun getRemoteUsersList(resultsCount: Int): RemoteUsersList =
        apiDataSource.getUsersList(resultsCount).await()

    override suspend fun insertUser(user: LocalUser) = userDao.insertUser(user)

    override suspend fun getLocalUsersList(): List<LocalUser> = userDao.getAllUsers().await()
}