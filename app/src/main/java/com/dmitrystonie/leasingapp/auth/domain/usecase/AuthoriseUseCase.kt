package com.dmitrystonie.leasingapp.auth.domain.usecase

import com.dmitrystonie.leasingapp.account.domain.UserAccount
import com.dmitrystonie.leasingapp.auth.domain.repository.AuthRepository

class AuthoriseUseCase(private val authRepository: AuthRepository) :
    suspend (String, String) -> UserAccount by { phone, optCode ->
        authRepository.authorise(
            phone, optCode
        )
    }