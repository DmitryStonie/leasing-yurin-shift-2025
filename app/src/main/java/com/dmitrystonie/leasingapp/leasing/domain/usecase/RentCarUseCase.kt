package com.dmitrystonie.leasingapp.domain.usecase

import com.dmitrystonie.leasingapp.domain.entity.rent.Rent
import com.dmitrystonie.leasingapp.domain.repository.LeasingRepository

class RentCarUseCase(private val leasingRepository: LeasingRepository) :
    suspend (Rent) -> List<Rent> by { rent -> leasingRepository.rentCar(rent) }
