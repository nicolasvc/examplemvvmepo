package com.example.data.repository

import com.example.data.LocalCategoryUserDataSource
import com.example.domain.UserDomain

class UserRepository(
    private val localCategoryUserDataSource : LocalCategoryUserDataSource
) {

    suspend fun createUser(user:UserDomain){
        localCategoryUserDataSource.insertUser(user)
    }

    suspend fun getListUser() = localCategoryUserDataSource.getAllUsers()

}