package com.example.randompeopletestapp.data.dto.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.randompeopletestapp.domain.entity.appstate.LocalUser
import kotlinx.coroutines.Deferred

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: LocalUser)

    @Query("SELECT * FROM users_table ORDER BY username DESC")
    fun getAllUsers(): Deferred<List<LocalUser>>

}