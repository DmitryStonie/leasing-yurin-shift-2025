package com.dmitrystonie.leasingapp.leasing.data.datasource.dto

data class RentsResponse(
    val success: Boolean,
    val reason: String?,
    val rent: List<RentDto>
)