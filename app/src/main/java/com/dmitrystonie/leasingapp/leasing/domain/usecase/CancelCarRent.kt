package com.dmitrystonie.leasingapp.domain.usecase

import com.dmitrystonie.leasingapp.domain.repository.LeasingRepository

class CancelCarRent(private val leasingRepository: LeasingRepository) {
    suspend fun invoke(carRentId: String) = leasingRepository.cancelRent(carRentId)
}