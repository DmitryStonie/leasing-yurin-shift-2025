package com.dmitrystonie.leasingapp.carlooking.data.repository

import com.dmitrystonie.leasingapp.carlooking.data.datasource.RemoteCarsDataSource
import com.dmitrystonie.leasingapp.carlooking.domain.repository.CarsRepository
import com.dmitrystonie.leasingapp.carlooking.domain.entity.SearchParameters
import com.dmitrystonie.leasingapp.domain.entity.car.Car
import com.dmitrystonie.leasingapp.carlooking.data.converter.toCar
import javax.inject.Inject

class CarsRepositoryImpl @Inject constructor(private val dataSource: RemoteCarsDataSource) :
    CarsRepository {
    override suspend fun getCars(params: SearchParameters?): List<Car> {
        val response = dataSource.getCars(params)
        if (response.success) {
            val cars = response.data
            if (cars == null || cars.isEmpty()) {
                return listOf()
            } else {
                val carsEntities = arrayListOf<Car>()
                for (carDto in cars) {
                    val carEntity = carDto.toCar()
                    if (carEntity != null) {
                        carsEntities.add(carEntity)
                    }
                }
                return carsEntities
            }
        } else {
            throw Exception("Network error")
        }
    }

    override suspend fun getCar(id: String): Car {
        val response = dataSource.getCar(id)
        if (response.success) {
            val car = response.data
            return car?.toCar() ?: throw Exception("Unable to parse car")
        } else {
            throw Exception("Network error")
        }
    }
}
