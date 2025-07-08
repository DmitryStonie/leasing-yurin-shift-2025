package com.dmitrystonie.leasingapp.leasing.data.datasource.dto


data class RentRequest (
    val carId: String,
    val pickupLocation: String,
    val returnLocation: String,
    val startDate: Long,
    val endDate: Long,
    val firstName: String,
    val lastName: String,
    val middleName: String?,
    val birthDate: String,
    val email: String,
    val phone: String,
    val comment: String?,
)