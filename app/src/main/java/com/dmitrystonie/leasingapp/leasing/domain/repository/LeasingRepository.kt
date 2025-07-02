package com.dmitrystonie.leasingapp.domain.repository

import com.dmitrystonie.leasingapp.domain.entity.rent.Rent
import java.sql.Timestamp

interface LeasingRepository {
    suspend fun rentCar(
        carId: String,
        pickupLocation: String,
        returnLocation: String,
        startDate: Timestamp,
        endDate: Timestamp,
        firstName: String,
        lastName: String,
        middleName: String?,
        birthDate: String,
        email: String,
        phone: String,
        comment: String
    ): List<Rent>
    suspend fun getRents(): List<Rent>
    suspend fun getRent(carRentId: String): Rent?
    suspend fun cancelRent(carRentId: String): Rent?
}