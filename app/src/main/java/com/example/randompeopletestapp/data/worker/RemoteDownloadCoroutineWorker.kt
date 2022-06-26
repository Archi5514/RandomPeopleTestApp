package com.example.randompeopletestapp.data.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.randompeopletestapp.data.dto.remote.ApiDataSource
import com.example.randompeopletestapp.domain.entity.LocalUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteDownloadCoroutineWorker(
    private val apiDataSource: ApiDataSource,
    private val receiversList: List<UsersUpdateReceiver>,
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        withContext(Dispatchers.IO) {
            try {
                val remoteUsersList = apiDataSource
                    .getUsersList(inputData.getInt("resultsCount", 50))
                    .await()

                val localUsersList = remoteUsersList.results.map { LocalUser.fromRemote(it) }
                receiversList.forEach { it.updateReceived(localUsersList) }

                return@withContext Result.success()
            } catch (e: Exception) {
                e.printStackTrace()
                return@withContext Result.failure()
            }
        }
        return Result.success()
    }
}