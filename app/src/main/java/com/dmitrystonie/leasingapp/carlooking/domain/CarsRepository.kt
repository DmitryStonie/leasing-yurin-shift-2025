package com.dmitrystonie.leasingapp.carlooking.domain

import com.dmitrystonie.leasingapp.domain.entity.car.BodyType
import com.dmitrystonie.leasingapp.domain.entity.car.Brand
import com.dmitrystonie.leasingapp.domain.entity.car.Car
import com.dmitrystonie.leasingapp.domain.entity.car.Color
import com.dmitrystonie.leasingapp.domain.entity.car.Transmission

interface CarsRepository {
    suspend fun getCars(search: String?, maxPrice: Int?, minPrice: Int?, transmission: Transmission?, bodyType: BodyType?, brand: Brand?, color: Color?, limit: Int?, page: Int?): List<Car>
    suspend fun getCar(id: String): Car?
}