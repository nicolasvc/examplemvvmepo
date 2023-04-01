package com.example.examplemvvmepo.features.user.creationuser

import com.example.data.repository.UserRepository
import com.example.usecases.user.CreateUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class CreationUserModule {

    @Provides
    @ViewModelScoped
    fun getCreationUserUseCaseProvider(
        userRepository: UserRepository
    ): CreateUserUseCase =CreateUserUseCase(userRepository)
}