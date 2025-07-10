package com.dmitrystonie.leasingapp.leasing.data.datasource

import com.dmitrystonie.leasingapp.domain.entity.rent.Rent
import com.dmitrystonie.leasingapp.leasing.data.datasource.dto.RentRequest
import javax.inject.Inject

class CarRentDataSource @Inject constructor(private val leasingService: LeasingService) {
    suspend fun rentCar(rent: Rent) = leasingService.rentCar(RentRequest(
        carId = rent.carId,
        pickupLocation = rent.pickupLocation,
        returnLocation = rent.returnLocation,
        startDate = rent.startDate,
        endDate = rent.endDate,
        firstName = rent.firstName,
        lastName = rent.lastName,
        middleName = rent.middleName,
        birthDate = rent.birthDate,
        email = rent.email,
        phone = rent.phone,
        comment = rent.comment
    ))
}