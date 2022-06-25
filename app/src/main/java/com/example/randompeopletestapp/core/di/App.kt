package com.example.randompeopletestapp.core.di

import android.app.Application
import com.example.randompeopletest.core.di.factory

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        factory { applicationContext }
        startDI()
    }
}