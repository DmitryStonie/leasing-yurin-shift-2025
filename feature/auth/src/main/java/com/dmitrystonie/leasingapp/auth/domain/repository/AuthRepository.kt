package com.dmitrystonie.leasingapp.auth.domain.repository

import UserAccount

interface AuthRepository {
    suspend fun createOtpCode(phone: String): Boolean
    suspend fun authorise(phone: String, otpCode: String): UserAccount
    suspend fun getUserSession(): UserAccount
    suspend fun deauthorise(): Boolean
}