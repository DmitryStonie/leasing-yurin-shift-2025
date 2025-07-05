package com.dmitrystonie.leasingapp.domain.repository

import com.dmitrystonie.leasingapp.domain.entity.rent.Rent

interface LeasingRepository {
    suspend fun rentCar(
        rent: Rent
    ): List<Rent>
    suspend fun getRents(): List<Rent>
    suspend fun getRent(carRentId: String): Rent?
    suspend fun cancelRent(carRentId: String): Rent?
}