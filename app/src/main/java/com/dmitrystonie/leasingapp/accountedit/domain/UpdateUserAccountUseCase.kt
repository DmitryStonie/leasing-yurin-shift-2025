package com.dmitrystonie.leasingapp.accountedit.domain

class UpdateUserAccountUseCase(private val accountRepository: AccountRepository) {
    suspend fun invoke(firstName: String?,
                       middleName: String?,
                       lastName: String?,
                       email: String?,
                       city: String?,
                       phone: String) = accountRepository.updateUserAccount(firstName, middleName, lastName, email, city, phone)
}