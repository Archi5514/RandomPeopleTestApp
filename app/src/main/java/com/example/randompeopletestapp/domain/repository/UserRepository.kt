package com.example.randompeopletestapp.domain.repository

import com.example.randompeopletestapp.domain.entity.UsersList

interface UserRepository {
    suspend fun getUsersList(resultsCount: Int): UsersList
}