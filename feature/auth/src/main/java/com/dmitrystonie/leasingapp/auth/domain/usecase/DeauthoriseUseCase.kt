package com.dmitrystonie.leasingapp.auth.domain.usecase

import com.dmitrystonie.leasingapp.auth.domain.repository.AuthRepository

class DeauthoriseUseCase(private val authRepository: AuthRepository) :
    suspend () -> Boolean by { authRepository.deauthorise() }
