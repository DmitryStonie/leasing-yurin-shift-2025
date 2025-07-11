package com.dmitrystonie.leasingapp.leasing.ui.confirmation

import kotlinx.serialization.Serializable

@Serializable
data class LeasingConfirmationRoute(
    val carId: String
)