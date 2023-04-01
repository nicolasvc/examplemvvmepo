package com.example.examplemvvmepo.framework.database.source

import com.example.data.LocalCategoryUserDataSource
import com.example.domain.UserDomain
import com.example.examplemvvmepo.framework.database.UserDataBase
import com.example.examplemvvmepo.framework.database.mapper.user.MapperUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList

class LocalUserDataSourceImpl(
    private val db:UserDataBase,
    private val mapperUser: MapperUser
) : LocalCategoryUserDataSource {

    private val userDao by lazy { db.getUserDao() }
    override suspend fun insertUser(user: UserDomain) {
        userDao.insertUser(mapperUser.convertToEntity(user))
    }

    override suspend fun getAllUsers(): Flow<List<UserDomain>> = userDao.getAllUser().map { listUser -> listUser.map { mapperUser.convertToDomain(it)}}


}