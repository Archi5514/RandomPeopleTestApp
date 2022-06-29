package com.example.randompeopletestapp.data.dto.remote

import com.example.randompeopletestapp.data.api.ApiService
import com.example.randompeopletestapp.domain.entity.RemoteUsersList
import kotlinx.coroutines.Deferred

class ApiDataSourceImpl(private val service: ApiService) : ApiDataSource {

    override fun getUsersList(resultsCount: Int): Deferred<RemoteUsersList> =
        service.getUsersList(resultsCount)

}