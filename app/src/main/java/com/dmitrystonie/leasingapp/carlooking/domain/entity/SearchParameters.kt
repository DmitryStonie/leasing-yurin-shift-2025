package com.dmitrystonie.leasingapp.carlooking.domain.entity

import com.dmitrystonie.leasingapp.domain.entity.car.BodyType
import com.dmitrystonie.leasingapp.domain.entity.car.Brand
import com.dmitrystonie.leasingapp.domain.entity.car.Color
import com.dmitrystonie.leasingapp.domain.entity.car.Transmission

data class SearchParameters(
    val search: String?,
    val maxPrice: Int?,
    val minPrice: Int?,
    val transmission: Transmission?,
    val bodyType: BodyType?,
    val brand: Brand?,
    val color: Color?,
    val limit: Int?,
    val page: Int?,
)