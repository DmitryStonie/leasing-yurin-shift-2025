package com.dmitrystonie.leasingapp.leasing.data.datasource.dto

data class RentResponse(
    val success: Boolean,
    val reason: String?,
    val rent: RentDto
)