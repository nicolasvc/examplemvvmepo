package com.example.examplemvvmepo.framework.database.mapper.user

import com.example.domain.UserDomain
import com.example.examplemvvmepo.framework.database.entities.UserEntity
import org.mapstruct.Mapper


@Mapper
interface MapperUser {

    fun convertToDomain(userEntity: UserEntity): UserDomain

    fun convertToEntity(userDomain: UserDomain): UserEntity
}