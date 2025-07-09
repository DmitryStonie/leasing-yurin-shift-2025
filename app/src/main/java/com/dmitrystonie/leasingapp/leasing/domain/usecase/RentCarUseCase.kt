package com.dmitrystonie.leasingapp.domain.usecase

import com.dmitrystonie.leasingapp.domain.entity.rent.Rent
import com.dmitrystonie.leasingapp.domain.repository.LeasingRepository
import javax.inject.Inject

class RentCarUseCase @Inject constructor(private val leasingRepository: LeasingRepository) :
    suspend (Rent) -> Rent by { rent -> leasingRepository.rentCar(rent) }
