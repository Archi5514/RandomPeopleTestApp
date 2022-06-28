package com.example.randompeopletestapp.data.repository

import com.example.randompeopletestapp.data.dto.local.UserDao
import com.example.randompeopletestapp.data.dto.remote.ApiDataSource
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser
import com.example.randompeopletestapp.domain.entity.RemoteUsersList
import com.example.randompeopletestapp.domain.repository.UserRepository
import kotlinx.coroutines.Deferred

class UserRepositoryImpl(
    private val apiDataSource: ApiDataSource,
    private val userDao: UserDao
) : UserRepository {

    override fun getRemoteUsersList(resultsCount: Int): Deferred<RemoteUsersList> =
        apiDataSource.getUsersList(resultsCount)

    override suspend fun insertUser(user: LocalUser) = userDao.insertUser(user)

    override suspend fun getLocalUsersList(): List<LocalUser> = userDao.getAllUsers()
}