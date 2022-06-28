package com.example.randompeopletestapp.core.di

import androidx.room.Room
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
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
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun startDI() {
    single {
        val client = OkHttpClient.Builder().build()

        Retrofit.Builder()
            .baseUrl(MAIN_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
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

    single { listOf(get<DatabaseUpdater>()) }

    single {
        val data = Data.Builder()
            .putInt(RESULTS_COUNT_KEY, 50)
            .build()

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        PeriodicWorkRequest.Builder(
            RemoteDownloadCoroutineWorker::class.java,
            REPEAT_REQUEST_INTERVAL,
            TimeUnit.SECONDS
        ).setInputData(data).setConstraints(constraints).build()
    }
}