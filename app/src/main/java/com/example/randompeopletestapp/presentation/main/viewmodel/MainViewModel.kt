package com.example.randompeopletestapp.presentation.main.viewmodel

import com.example.randompeopletestapp.core.AppState
import com.example.randompeopletestapp.core.BaseViewModel
import com.example.randompeopletestapp.core.di.get
import com.example.randompeopletestapp.core.di.single
import com.example.randompeopletestapp.data.worker.UsersUpdateReceiver
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser
import com.example.randompeopletestapp.domain.entity.appstate.LocalUsersList
import com.example.randompeopletestapp.domain.repository.UserRepository
import com.example.randompeopletestapp.presentation.main.viewstate.MainViewState
import java.lang.IndexOutOfBoundsException

class MainViewModel : BaseViewModel<MainViewState>(), UsersUpdateReceiver {

    var currentImage: String? = null

    private var currentUser: LocalUser? = null
    private var usersList = mutableListOf<LocalUser>()

    init {
        single { this }
    }

    override fun onViewInit() {
        super.onViewInit()

        runAsync {
            val cachedList = get<UserRepository>().getLocalUsersList()

            try {
                currentUser = cachedList[0]
                currentImage = currentUser?.largePic
            } catch (e: IndexOutOfBoundsException) {
                return@runAsync
            }

            usersList.addAll(cachedList)
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

    override suspend fun updateReceived(users: List<LocalUser>) {
        runAsync {
            currentUser?.let {
                // initialized - do nothing
            } ?: kotlin.run {
                currentUser = users[0]
                currentImage = currentUser?.largePic
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
            currentImage = user.largePic
            stateLiveData.postValue(AppState.Success(MainViewState(currentUser = currentUser)))
        }
    }
}