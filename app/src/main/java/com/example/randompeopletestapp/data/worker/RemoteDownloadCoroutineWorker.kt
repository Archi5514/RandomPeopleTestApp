package com.example.randompeopletestapp.data.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.randompeopletestapp.core.di.get
import com.example.randompeopletestapp.core.di.single
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser
import com.example.randompeopletestapp.domain.repository.UserRepository
import com.example.randompeopletestapp.presentation.main.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

const val RESULTS_COUNT_KEY = "resultsCount"
const val REPEAT_REQUEST_INTERVAL = 10L

class RemoteDownloadCoroutineWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    private val usersUpdateReceiversList = mutableListOf<UsersUpdateReceiver>()

    init {
        usersUpdateReceiversList.add(get<DatabaseUpdater>())
    }

    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            try {
                usersUpdateReceiversList.add(get<MainViewModel>())
                val userRepository = get<UserRepository>()
                val remoteUsersList = userRepository
                    .getRemoteUsersList(inputData.getInt(RESULTS_COUNT_KEY, 50)).await()

                val localUsersList = remoteUsersList.results.map { LocalUser.fromRemote(it) }
                usersUpdateReceiversList.forEach {
                    it.updateReceived(localUsersList)
                }
                Result.retry()
            } catch (e: Exception) {
                e.printStackTrace()
                Result.failure()
            }
        }
    }
}