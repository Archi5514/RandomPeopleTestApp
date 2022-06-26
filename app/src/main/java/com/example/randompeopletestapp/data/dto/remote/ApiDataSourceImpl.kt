package com.example.randompeopletestapp.data.dto.remote

import com.example.randompeopletestapp.data.api.ApiService
import com.example.randompeopletestapp.domain.entity.UsersList
import kotlinx.coroutines.Deferred

class ApiDataSourceImpl(private val service: ApiService) : ApiDataSource {

    override fun getRandomUser(results: Int): Deferred<UsersList> = service.getRandomUser(results)

}