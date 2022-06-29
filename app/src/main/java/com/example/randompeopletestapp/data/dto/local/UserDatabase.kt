package com.example.randompeopletestapp.data.dto.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser

@Database(entities = [LocalUser::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getDao(): UserDao
}