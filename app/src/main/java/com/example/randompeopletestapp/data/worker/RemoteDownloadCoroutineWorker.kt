package com.example.randompeopletestapp.data.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.randompeopletest.core.di.get
import com.example.randompeopletestapp.data.dto.remote.ApiDataSource
import com.example.randompeopletestapp.domain.entity.LocalUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

const val RESULTS_COUNT_KEY = "resultsCount"
const val REPEAT_REQUEST_INTERVAL = 10L

class RemoteDownloadCoroutineWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        withContext(Dispatchers.IO) {
            try {
                val remoteUsersList = get<ApiDataSource>()
                    .getUsersList(inputData.getInt(RESULTS_COUNT_KEY, 50))
                    .await()

                val localUsersList = remoteUsersList.results.map { LocalUser.fromRemote(it) }
                get<List<UsersUpdateReceiver>>().forEach { it.updateReceived(localUsersList) }

                return@withContext Result.success()
            } catch (e: Exception) {
                e.printStackTrace()
                return@withContext Result.failure()
            }
        }
        return Result.success()
    }
}