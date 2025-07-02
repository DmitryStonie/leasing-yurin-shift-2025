package com.dmitrystonie.leasingapp.auth.domain.usecase

import com.dmitrystonie.leasingapp.auth.domain.repository.AuthRepository

class CreateOptCodeUseCase(private val authRepository: AuthRepository) {
    suspend fun invoke(phone: String) = authRepository.createOtpCode(phone)
}