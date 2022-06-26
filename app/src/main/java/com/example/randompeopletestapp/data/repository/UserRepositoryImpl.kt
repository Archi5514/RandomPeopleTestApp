package com.example.randompeopletestapp.data.repository

import com.example.randompeopletestapp.data.dto.remote.ApiDataSource
import com.example.randompeopletestapp.domain.entity.UsersList
import com.example.randompeopletestapp.domain.repository.UserRepository

class UserRepositoryImpl(val apiDataSource: ApiDataSource) : UserRepository {

    override suspend fun getUsersList(resultsCount: Int): UsersList =
        apiDataSource.getUsersList(resultsCount).await()

}