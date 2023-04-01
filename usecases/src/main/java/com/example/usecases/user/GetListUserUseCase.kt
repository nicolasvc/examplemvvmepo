package com.example.usecases.user

import com.example.data.repository.UserRepository

class GetListUserUseCase(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke() = userRepository.getListUser()
}