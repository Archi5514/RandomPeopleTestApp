package com.example.randompeopletestapp.core.di

import androidx.room.Room
import com.example.randompeopletest.core.di.get
import com.example.randompeopletest.core.di.single
import com.example.randompeopletestapp.data.api.ApiService
import com.example.randompeopletestapp.data.api.MAIN_API_URL
import com.example.randompeopletestapp.data.dto.local.UserDatabase
import com.example.randompeopletestapp.data.repository.UserRepositoryImpl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
    single { UserRepositoryImpl(get(), get()) }
}