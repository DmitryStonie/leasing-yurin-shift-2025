package com.dmitrystonie.leasingapp.auth.domain.usecase

import UserAccount
import com.dmitrystonie.leasingapp.auth.domain.repository.AuthRepository

class GetUserSessionUseCase(private val authRepository: AuthRepository) :
    suspend () -> UserAccount by { authRepository.getUserSession() }
