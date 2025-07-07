package com.dmitrystonie.leasingapp.carlooking.data.repository

import com.dmitrystonie.leasingapp.carlooking.data.datasource.RemoteCarsDataSource
import com.dmitrystonie.leasingapp.carlooking.domain.repository.CarsRepository
import com.dmitrystonie.leasingapp.carlooking.domain.entity.SearchParameters
import com.dmitrystonie.leasingapp.domain.entity.car.Car
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.dmitrystonie.leasingapp.carlooking.data.converter.toCar

class CarsRepositoryImpl(private val dataSource: RemoteCarsDataSource) : CarsRepository {
    override suspend fun getCars(params: SearchParameters): List<Car>? {
        return withContext(Dispatchers.IO) {
            val response = dataSource.getCars(params)
            if(response.isSuccessful){
                val cars = response.body()?.data
                if(cars == null || cars.isEmpty()){
                    return@withContext null
                } else{
                    return@withContext cars.map { carDto -> carDto.toCar() }
                }
            } else{
                return@withContext null
            }
        }
    }

    override suspend fun getCar(id: String): Car? {
        return withContext(Dispatchers.IO) {
            val response = dataSource.getCar(id)
            if(response.isSuccessful){
                val car = response.body()?.data
                return@withContext car?.toCar()
            } else{
                return@withContext null
            }
        }
    }
}