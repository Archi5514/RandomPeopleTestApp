package com.example.randompeopletestapp.core.di

import androidx.room.Room
import androidx.work.*
import com.example.randompeopletest.core.di.factory
import com.example.randompeopletest.core.di.get
import com.example.randompeopletest.core.di.single
import com.example.randompeopletestapp.data.api.ApiService
import com.example.randompeopletestapp.data.api.MAIN_API_URL
import com.example.randompeopletestapp.data.dto.local.UserDatabase
import com.example.randompeopletestapp.data.dto.remote.ApiDataSourceImpl
import com.example.randompeopletestapp.data.repository.UserRepositoryImpl
import com.example.randompeopletestapp.data.worker.*
import com.example.randompeopletestapp.presentation.main.viewmodel.MainViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun startDI() {
    single {
        Retrofit.Builder()
            .baseUrl(MAIN_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build().create(ApiService::class.java)
    }
    single {
        Room.databaseBuilder(
            get(),
            UserDatabase::class.java,
            "user_database"
        ).build()
    }
    val database: UserDatabase = get()

    single { database.getDao() }
    single { ApiDataSourceImpl(get()) }

    factory { UserRepositoryImpl(get(), get()) }
    factory { DatabaseUpdater(get()) }
}