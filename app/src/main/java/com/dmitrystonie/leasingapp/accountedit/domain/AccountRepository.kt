package com.dmitrystonie.leasingapp.accountedit.domain

import com.dmitrystonie.leasingapp.account.domain.UserAccount

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