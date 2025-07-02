package com.dmitrystonie.leasingapp.domain.usecase

import com.dmitrystonie.leasingapp.domain.repository.LeasingRepository

class GetRentsUseCase(private val leasingRepository: LeasingRepository) {
    suspend fun invoke() = leasingRepository.getRents()
}