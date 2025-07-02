package com.dmitrystonie.leasingapp.auth.domain.usecase

import com.dmitrystonie.leasingapp.auth.domain.repository.AuthRepository

class AuthoriseUseCase(private val authRepository: AuthRepository) {
    suspend fun invoke(phone: String, optCode: String) = authRepository.authorise(phone, optCode)
}