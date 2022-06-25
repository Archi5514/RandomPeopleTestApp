package com.example.randompeopletestapp.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

abstract class BaseViewModel<D : AppStateEntity> : ViewModel() {

    protected val stateLiveData = MutableLiveData<AppState<D>>()
    val stateData: LiveData<AppState<D>>
        get() = stateLiveData

    private val ioCoroutineScope = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        }
    )

    private val mainCoroutineScope = CoroutineScope(
        Dispatchers.Main
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        }
    )

    override fun onCleared() {
        super.onCleared()
        cancelJob()
    }

    open fun handleError(error: Throwable) {
        error.printStackTrace()
        runAsync {
            stateLiveData.postValue(AppState.Error(error))
        }
    }

    open fun onViewInit() {}

    protected open fun cancelJob() {
        ioCoroutineScope.coroutineContext.cancelChildren()
    }

    protected fun runAsync(block: suspend () -> Unit) = ioCoroutineScope.launch { block() }

    protected fun runOnMainThread(block: suspend () -> Unit) = mainCoroutineScope.launch { block() }
}