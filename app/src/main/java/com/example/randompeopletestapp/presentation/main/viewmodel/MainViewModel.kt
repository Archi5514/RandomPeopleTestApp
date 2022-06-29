package com.example.randompeopletestapp.presentation.main.viewmodel

import com.example.randompeopletestapp.core.AppState
import com.example.randompeopletestapp.core.BaseViewModel
import com.example.randompeopletestapp.core.di.single
import com.example.randompeopletestapp.data.worker.UsersUpdateReceiver
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser
import com.example.randompeopletestapp.domain.entity.appstate.LocalUsersList
import com.example.randompeopletestapp.presentation.main.viewstate.MainViewState

class MainViewModel : BaseViewModel<MainViewState>(), UsersUpdateReceiver {

    private var currentUser: LocalUser? = null
    private var usersList = mutableListOf<LocalUser>()

    init {
        single { this }
    }

    override suspend fun updateReceived(users: List<LocalUser>) {
        runAsync {
            currentUser?.let {
                // initialized - do nothing
            } ?: kotlin.run {
                currentUser = users[0]
            }

            usersList.addAll(users)

            stateLiveData.postValue(
                AppState.Success(
                    MainViewState(
                        LocalUsersList(usersList),
                        currentUser
                    )
                )
            )
        }
    }

    fun onUserClicked(user: LocalUser) {
        runAsync {
            currentUser = user
            stateLiveData.postValue(AppState.Success(MainViewState(currentUser = currentUser)))
        }
    }
}