package com.example.randompeopletestapp.presentation.main.viewmodel

import android.util.Log
import com.example.randompeopletest.core.di.get
import com.example.randompeopletestapp.core.AppState
import com.example.randompeopletestapp.core.BaseViewModel
import com.example.randompeopletestapp.data.worker.RemoteDownloadCoroutineWorker
import com.example.randompeopletestapp.data.worker.UsersUpdateReceiver
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser
import com.example.randompeopletestapp.domain.entity.appstate.LocalUsersList
import com.example.randompeopletestapp.presentation.main.viewstate.MainViewState

class MainViewModel : BaseViewModel<MainViewState>(), UsersUpdateReceiver {

    init {
        //val worker = get<RemoteDownloadCoroutineWorker>()
        //worker.usersUpdateReceiversList.add(this)
    }

    override suspend fun updateReceived(users: List<LocalUser>) {
        stateLiveData.postValue(AppState.Success(LocalUsersList(users)))
        stateLiveData.postValue(AppState.Success(users[0]))
    }

    fun onUserClicked(user: LocalUser) {
        stateLiveData.postValue(AppState.Success(user))
    }

}