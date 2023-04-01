package com.example.examplemvvmepo.framework.database.daos

import androidx.room.*
import com.example.examplemvvmepo.framework.database.entities.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(recipeEntity: UserEntity)

    @Delete
    suspend fun deleteUser(recipeEntity: UserEntity)

    @Query("SELECT * FROM UserEntity")
    fun getAllUser():Flow<List<UserEntity>>
}