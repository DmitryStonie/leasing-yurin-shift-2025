package com.dmitrystonie.leasingapp.carlooking.domain.repository

import com.dmitrystonie.leasingapp.carlooking.domain.entity.SearchParameters
import com.dmitrystonie.leasingapp.domain.entity.car.Car

interface CarsRepository {
    suspend fun getCars(params: SearchParameters): List<Car>?
    suspend fun getCar(id: String): Car?
}