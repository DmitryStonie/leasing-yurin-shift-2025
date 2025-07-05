package com.dmitrystonie.leasingapp.domain.usecase

import com.dmitrystonie.leasingapp.domain.entity.rent.Rent
import com.dmitrystonie.leasingapp.domain.repository.LeasingRepository

class GetRentsUseCase(private val leasingRepository: LeasingRepository) :
    suspend () -> List<Rent> by { leasingRepository.getRents() }
