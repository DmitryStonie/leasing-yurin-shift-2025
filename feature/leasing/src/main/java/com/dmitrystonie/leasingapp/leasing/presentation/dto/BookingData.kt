package com.dmitrystonie.leasingapp.leasing.presentation.dto

import com.dmitrystonie.leasingapp.car.domain.Rent

data class BookingData(
    val rent: Rent?,
    val pickupLocation: String?,
    val returnLocation: String?,
)
