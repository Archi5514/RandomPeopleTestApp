package com.example.randompeopletestapp.core.di

import android.app.Application
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.randompeopletest.core.di.factory
import com.example.randompeopletest.core.di.get

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        factory { applicationContext }
        startDI()
        WorkManager.getInstance().enqueue(get<PeriodicWorkRequest>())
    }
}