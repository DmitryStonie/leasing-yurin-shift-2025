package com.dmitrystonie.leasingapp.leasing.presentation.dto

data class ContactsData(
    val lastName: String?,
    val firstName: String?,
    val middleName: String?,
    val birthDate: String?,
    val phone: String?,
    val email: String?,
    val comment: String?,
    val agreement: Boolean?,
)