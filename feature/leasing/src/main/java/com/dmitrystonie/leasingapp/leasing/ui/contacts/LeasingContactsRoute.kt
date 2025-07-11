package com.dmitrystonie.leasingapp.leasing.ui.contacts

import kotlinx.serialization.Serializable

@Serializable
data class LeasingContactsRoute(
    val carId: String
)