package com.example.examplemvvmepo.features.listusers

import com.example.data.repository.UserRepository
import com.example.usecases.user.CreateUserUseCase
import com.example.usecases.user.GetListUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ListUserModule {

    @Provides
    @ViewModelScoped
    fun getGetListUserUseCaseProvider(
        userRepository: UserRepository
    ): GetListUserUseCase = GetListUserUseCase(userRepository)
}