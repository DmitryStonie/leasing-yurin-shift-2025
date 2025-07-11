package com.dmitrystonie.leasingapp.domain.usecase

import com.dmitrystonie.leasingapp.domain.entity.car.Car
import com.dmitrystonie.leasingapp.carlooking.domain.repository.CarsRepository
import com.dmitrystonie.leasingapp.carlooking.domain.entity.SearchParameters
import javax.inject.Inject

class GetCarsUseCase @Inject constructor(private val carsRepository: CarsRepository) :
    suspend (SearchParameters?) -> List<Car> by { params -> carsRepository.getCars(params) }
