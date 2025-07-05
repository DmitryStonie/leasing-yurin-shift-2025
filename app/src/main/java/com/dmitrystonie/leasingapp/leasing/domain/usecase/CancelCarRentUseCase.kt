package com.dmitrystonie.leasingapp.domain.usecase

import com.dmitrystonie.leasingapp.domain.entity.rent.Rent
import com.dmitrystonie.leasingapp.domain.repository.LeasingRepository

class CancelCarRentUseCase(private val leasingRepository: LeasingRepository) :
    suspend (String) -> Rent? by { carRentId -> leasingRepository.cancelRent(carRentId) }
