package com.dmitrystonie.leasingapp.leasing.data.datasource.dto


data class RentDto (
    val carId: String,
    val status: Int,
    val pickupLocation: String,
    val returnLocation: String,
    val startDate: Long,
    val endDate: Long,
    val totalPrice: Int,
    val firstName: String,
    val lastName: String,
    val middleName: String?,
    val birthDate: String,
    val email: String,
    val phone: String,
    val comment: String?,
    )