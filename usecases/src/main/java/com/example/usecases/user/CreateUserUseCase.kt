package com.example.usecases.user

import com.example.data.repository.UserRepository
import com.example.domain.UserDomain

class CreateUserUseCase(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(user: UserDomain) = userRepository.createUser(user)
}