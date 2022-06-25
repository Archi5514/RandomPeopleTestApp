package com.example.randompeopletestapp.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

abstract class BaseViewModel<D : AppStateEntity> : ViewModel() {

    protected val mStateLiveData = MutableLiveData<AppState<D>>()

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

    protected open fun cancelJob() {
        ioCoroutineScope.coroutineContext.cancelChildren()
    }

    open fun handleError(error: Throwable) {
        error.printStackTrace()
        runAsync {
            mStateLiveData.postValue(AppState.Error(error))
        }
    }

    protected fun runAsync(block: suspend () -> Unit) = ioCoroutineScope.launch { block() }

    protected fun runOnMainThread(block: suspend () -> Unit) = mainCoroutineScope.launch { block() }
}