package com.example.examplemvvmepo.di

import com.example.examplemvvmepo.framework.database.mapper.user.MapperUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mapstruct.factory.Mappers

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Provides
    fun providesMapperClosing(): MapperUser = Mappers.getMapper(MapperUser::class.java)
}