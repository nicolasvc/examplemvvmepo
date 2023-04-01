package com.example.data

import com.example.domain.UserDomain
import kotlinx.coroutines.flow.Flow

interface LocalCategoryUserDataSource {

    suspend fun insertUser(user: UserDomain)

    suspend fun getAllUsers() : Flow<List<UserDomain>>

}