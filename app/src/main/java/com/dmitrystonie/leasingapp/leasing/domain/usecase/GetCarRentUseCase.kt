package com.dmitrystonie.leasingapp.domain.usecase

import com.dmitrystonie.leasingapp.domain.repository.LeasingRepository

class GetCarRentUseCase(private val leasingRepository: LeasingRepository) {
    suspend fun invoke(carRentId: String) = leasingRepository.getRent(carRentId)
}