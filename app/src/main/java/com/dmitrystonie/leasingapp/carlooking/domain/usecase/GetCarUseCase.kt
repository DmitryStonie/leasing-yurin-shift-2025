package com.dmitrystonie.leasingapp.domain.usecase

import com.dmitrystonie.leasingapp.carlooking.domain.repository.CarsRepository
import com.dmitrystonie.leasingapp.domain.entity.car.Car

class GetCarUseCase(private val carsRepository: CarsRepository) :
    suspend (String) -> Car? by { id -> carsRepository.getCar(id) }
