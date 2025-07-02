package com.dmitrystonie.leasingapp.domain.entity.rent

import java.sql.Timestamp

data class Rent (
    val carId: Int,
    val status: RentStatus,
    val pickupLocation: String,
    val returnLocation: String,
    val startDate: Timestamp,
    val endDate: Timestamp,
    val totalPrice: Int,
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val birthDate: String,
    val email: String,
    val phone: String,
    val comment: String
)