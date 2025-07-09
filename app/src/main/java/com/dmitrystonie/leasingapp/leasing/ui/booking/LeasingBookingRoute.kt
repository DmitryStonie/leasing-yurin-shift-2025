package com.dmitrystonie.leasingapp.leasing.ui.booking

import kotlinx.serialization.Serializable

@Serializable
data class LeasingBookingRoute(
    val carId: String
)