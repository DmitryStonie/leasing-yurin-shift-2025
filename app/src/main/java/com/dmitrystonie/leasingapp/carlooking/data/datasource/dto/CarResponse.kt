package com.dmitrystonie.leasingapp.carlooking.data.datasource.dto

data class CarResponse(
    val success: Boolean,
    val reason: String?,
    val data: CarWithRentDto,
)