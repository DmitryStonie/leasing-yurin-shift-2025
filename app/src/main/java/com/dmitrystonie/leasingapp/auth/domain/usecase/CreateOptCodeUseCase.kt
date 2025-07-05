package com.dmitrystonie.leasingapp.auth.domain.usecase

import com.dmitrystonie.leasingapp.auth.domain.repository.AuthRepository

class CreateOptCodeUseCase(private val authRepository: AuthRepository) :
    suspend (String) -> Boolean by { phone -> authRepository.createOtpCode(phone) }
