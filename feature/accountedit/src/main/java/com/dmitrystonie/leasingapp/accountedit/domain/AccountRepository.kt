package com.dmitrystonie.leasingapp.accountedit.domain

import UserAccount

interface AccountRepository {
    suspend fun updateUserAccount(
        firstName: String?,
        middleName: String?,
        lastName: String?,
        email: String?,
        city: String?,
        phone: String,
    ): UserAccount
}