package com.dmitrystonie.leasingapp.carlooking.data.datasource

import com.dmitrystonie.leasingapp.network.CarsService
import com.dmitrystonie.leasingapp.carlooking.domain.entity.SearchParameters
import javax.inject.Inject

class RemoteCarsDataSource @Inject constructor(private val carsService: CarsService) {
    suspend fun getCars(params: SearchParameters?) = carsService.getCars(
        search = params?.search,
        maxPrice = params?.maxPrice,
        minPrice = params?.minPrice,
        transmission = params?.transmission?.type,
        bodyType = params?.bodyType?.type,
        brand = params?.brand?.brandName,
        color = params?.color?.colorName,
        limit = params?.limit,
        page = params?.page
    )


    suspend fun getCar(id: String) = carsService.getCar(id)
}