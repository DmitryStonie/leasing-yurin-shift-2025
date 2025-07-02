package com.dmitrystonie.leasingapp.domain.usecase

import com.dmitrystonie.leasingapp.domain.entity.car.BodyType
import com.dmitrystonie.leasingapp.domain.entity.car.Brand
import com.dmitrystonie.leasingapp.domain.entity.car.Car
import com.dmitrystonie.leasingapp.domain.entity.car.Color
import com.dmitrystonie.leasingapp.domain.entity.car.Transmission
import com.dmitrystonie.leasingapp.carlooking.domain.CarsRepository

class GetCarsUseCase(private val carsRepository: CarsRepository) {
    suspend fun invoke(search: String?, maxPrice: Int?, minPrice: Int?, transmission: Transmission?, bodyType: BodyType?, brand: Brand?, color: Color?, limit: Int?, page: Int?): List<Car> =
        carsRepository.getCars(search,maxPrice, minPrice,transmission,bodyType,brand,color,limit, page)
}