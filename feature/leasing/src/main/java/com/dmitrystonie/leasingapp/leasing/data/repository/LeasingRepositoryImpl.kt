package com.dmitrystonie.leasingapp.leasing.data.repository

import com.dmitrystonie.leasingapp.domain.entity.rent.Rent
import com.dmitrystonie.leasingapp.domain.repository.LeasingRepository
import com.dmitrystonie.leasingapp.leasing.data.converter.toRent
import com.dmitrystonie.leasingapp.leasing.data.datasource.CarRentDataSource
import javax.inject.Inject

class LeasingRepositoryImpl @Inject constructor(private val dataSource: CarRentDataSource) :
    LeasingRepository {
    override suspend fun rentCar(rent: Rent): Rent {
        val response = dataSource.rentCar(rent)
        return if (response.isSuccessful && response.body() != null && response.body()!!.success == true) {
            return response.body()!!.rent.toRent()
        } else {
            throw Exception("Network error")
        }
    }

    override suspend fun getRents(): List<Rent> {
        // stub
        return listOf()
    }

    override suspend fun getRent(carRentId: String): Rent? {
        // stub
        return null
    }

    override suspend fun cancelRent(carRentId: String): Rent? {
        // stub
        return null
    }
}