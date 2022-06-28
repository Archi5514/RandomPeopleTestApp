package com.example.randompeopletestapp.core.di

import android.app.Application
import androidx.work.*
import com.example.randompeopletest.core.di.factory
import com.example.randompeopletest.core.di.get
import com.example.randompeopletestapp.data.worker.REPEAT_REQUEST_INTERVAL
import com.example.randompeopletestapp.data.worker.RESULTS_COUNT_KEY
import com.example.randompeopletestapp.data.worker.RemoteDownloadCoroutineWorker
import java.util.concurrent.TimeUnit

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        factory { applicationContext }
        startDI()
        setupWorkRequest()
    }

    private fun setupWorkRequest() {
        val data = Data.Builder()
            .putInt(RESULTS_COUNT_KEY, 50)
            .build()

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val request = OneTimeWorkRequest.Builder(
            RemoteDownloadCoroutineWorker::class.java
        ).setInputData(data).setConstraints(constraints).build()

        WorkManager.getInstance().enqueue(request)
    }

}