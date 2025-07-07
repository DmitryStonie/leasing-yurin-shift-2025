package com.dmitrystonie.leasingapp.leasing.ui.orders

import kotlinx.serialization.Serializable

@Serializable
data class LeasingOrdersRoute(
    val carId: String
)