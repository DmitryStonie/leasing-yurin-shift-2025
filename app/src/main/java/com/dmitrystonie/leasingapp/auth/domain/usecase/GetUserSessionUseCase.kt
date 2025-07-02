package com.dmitrystonie.leasingapp.auth.domain.usecase

import com.dmitrystonie.leasingapp.auth.domain.repository.AuthRepository

class GetUserSessionUseCase(private val authRepository: AuthRepository) {
    suspend fun invoke() = authRepository.getUserSession()
}