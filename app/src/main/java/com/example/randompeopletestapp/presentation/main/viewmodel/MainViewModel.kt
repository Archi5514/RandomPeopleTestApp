package com.example.randompeopletestapp.presentation.main.viewmodel

import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.randompeopletestapp.core.di.get
import com.example.randompeopletestapp.core.AppState
import com.example.randompeopletestapp.core.BaseViewModel
import com.example.randompeopletestapp.core.di.single
import com.example.randompeopletestapp.data.worker.RemoteDownloadCoroutineWorker
import com.example.randompeopletestapp.data.worker.UsersUpdateReceiver
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser
import com.example.randompeopletestapp.domain.entity.appstate.LocalUsersList
import com.example.randompeopletestapp.presentation.main.viewstate.MainViewState

class MainViewModel : BaseViewModel<MainViewState>(), UsersUpdateReceiver {

    init {
        val worker = get<RemoteDownloadCoroutineWorker>()
        worker.usersUpdateReceiversList.add(this)
    }

    override suspend fun updateReceived(users: List<LocalUser>) {
        runAsync {
            stateLiveData.postValue(
                AppState.Success(
                    MainViewState(
                        LocalUsersList(users),
                        users[0]
                    )
                )
            )
        }
    }

    fun onUserClicked(user: LocalUser) {
        runAsync {
            stateLiveData.postValue(AppState.Success(MainViewState(currentUser = user)))
        }
    }
}