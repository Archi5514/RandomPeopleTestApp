package com.example.randompeopletestapp.data.api

import com.example.randompeopletestapp.domain.entity.RemoteUsersList
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

const val MAIN_API_URL = "https://randomuser.me"

interface ApiService {

    @GET("api")
    fun getUsersList(@Query("results") resultsCount: Int): Deferred<RemoteUsersList>

}