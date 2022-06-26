package com.example.randompeopletestapp.data.api

import com.example.randompeopletestapp.domain.entity.UsersList
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api")
    fun getUsersList(@Query("results") resultsCount: Int): Deferred<UsersList>

}