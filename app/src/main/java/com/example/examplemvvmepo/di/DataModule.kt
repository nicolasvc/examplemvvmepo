package com.example.examplemvvmepo.di

import android.app.Application
import com.example.data.LocalCategoryUserDataSource
import com.example.data.repository.UserRepository
import com.example.examplemvvmepo.framework.database.UserDataBase
import com.example.examplemvvmepo.framework.database.mapper.user.MapperUser
import com.example.examplemvvmepo.framework.database.source.LocalUserDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideDataBase(application: Application): UserDataBase =
        UserDataBase.getDatabase(application)

    @Provides
    fun localUserDataSourceProvider(
        db: UserDataBase,
        mapperUser: MapperUser
    ): LocalCategoryUserDataSource = LocalUserDataSourceImpl(db,mapperUser)

    @Provides
    fun repositoryUserProvider(
        localCategoryUserDataSource: LocalCategoryUserDataSource
    ): UserRepository = UserRepository(localCategoryUserDataSource)

}