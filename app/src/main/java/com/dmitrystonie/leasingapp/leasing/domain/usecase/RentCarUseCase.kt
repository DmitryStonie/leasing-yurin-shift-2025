package com.dmitrystonie.leasingapp.domain.usecase

import com.dmitrystonie.leasingapp.domain.repository.LeasingRepository
import java.sql.Timestamp

class RentCarUseCase(private val leasingRepository: LeasingRepository) {
    suspend fun invoke(
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
    ) =
        leasingRepository.rentCar(
            carId,
            pickupLocation,
            returnLocation,
            startDate,
            endDate,
            firstName,
            lastName,
            middleName,
            birthDate,
            email,
            phone,
            comment
        )

}