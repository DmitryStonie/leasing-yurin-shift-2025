package com.dmitrystonie.leasingapp.network

import com.dmitrystonie.leasingapp.carlooking.data.datasource.dto.CarPaginatedResponse
import com.dmitrystonie.leasingapp.carlooking.data.datasource.dto.CarResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CarsService {
    @GET("/api/cars/info/{id}")
    suspend fun getCar(@Path("id") carId: String): Response<CarResponse>

    @GET("/api/cars/info")
    suspend fun getCars(
        @Query("search") search: String?,
        @Query("maxPrice") maxPrice: Int?,
        @Query("minPrice") minPrice: Int?,
        @Query("transmission") transmission: String?,
        @Query("bodyType") bodyType: String?,
        @Query("brand") brand: String?,
        @Query("color") color: String?,
        @Query("limit") limit: Int?,
        @Query("page") page: Int?,
    ): Response<CarPaginatedResponse>
}