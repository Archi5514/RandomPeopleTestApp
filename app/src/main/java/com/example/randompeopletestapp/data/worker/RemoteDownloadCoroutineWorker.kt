package com.example.randompeopletestapp.data.worker

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.randompeopletest.core.di.get
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser
import com.example.randompeopletestapp.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

const val RESULTS_COUNT_KEY = "resultsCount"
const val REPEAT_REQUEST_INTERVAL = 10L

class RemoteDownloadCoroutineWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            try {
                val userRepository = get<UserRepository>()
                val remoteUsersList = userRepository
                    .getRemoteUsersList(inputData.getInt(RESULTS_COUNT_KEY, 50)).await()

                val localUsersList = remoteUsersList.results.map { LocalUser.fromRemote(it) }
                get<DatabaseUpdater>().updateReceived(localUsersList)
                Result.success()
            } catch (e: Exception) {
                e.printStackTrace()
                Result.failure()
            }
        }
    }
}