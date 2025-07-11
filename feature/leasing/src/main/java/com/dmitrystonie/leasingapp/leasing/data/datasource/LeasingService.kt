package com.dmitrystonie.leasingapp.leasing.data.datasource

import com.dmitrystonie.leasingapp.leasing.data.datasource.dto.CarPaginatedResponse
import com.dmitrystonie.leasingapp.leasing.data.datasource.dto.RentDto
import com.dmitrystonie.leasingapp.leasing.data.datasource.dto.RentRequest
import com.dmitrystonie.leasingapp.leasing.data.datasource.dto.RentResponse
import com.dmitrystonie.leasingapp.leasing.data.datasource.dto.RentsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface LeasingService {
    @POST("/api/cars/rent")
    suspend fun rentCar(@Body body: RentRequest): Response<RentResponse>

    @GET("/api/cars/rent")
    suspend fun getRents(
    ): Response<RentsResponse>

    @GET("/api/cars/rent/{carRentId}")
    suspend fun getRent(@Query("id") carRentId: String
    ): Response<RentDto>

    @PUT("/api/cars/rent/cancel")
    suspend fun cancelRent(@Body carRentId: String
    ): Response<CarPaginatedResponse>
}