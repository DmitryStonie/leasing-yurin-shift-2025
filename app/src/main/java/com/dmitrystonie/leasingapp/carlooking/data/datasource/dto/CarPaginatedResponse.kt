package com.dmitrystonie.leasingapp.carlooking.data.datasource.dto

data class CarPaginatedResponse(
    val success: Boolean,
    val reason: String?,
    val data: List<CarDto>?,
    val meta: PaginationMeta,
)