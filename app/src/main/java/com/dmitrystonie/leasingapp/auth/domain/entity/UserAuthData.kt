package com.dmitrystonie.leasingapp.auth.domain.entity

data class UserAuthData(
    val phone: String,
    val verificationCode: String
)