package com.dmitrystonie.leasingapp.domain.usecase

import com.dmitrystonie.leasingapp.carlooking.domain.CarsRepository

class GetCarUseCase(private val carsRepository: CarsRepository) {
    suspend fun invoke(id: String) = carsRepository.getCar(id)
}