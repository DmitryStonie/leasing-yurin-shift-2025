package com.dmitrystonie.leasingapp.carlooking.data.datasource.dto


data class CarDto(
    val id: String,
    val name: String,
    val brand: String,
    val media: List<MediaDto>,
    val transmission: String,
    val price: Int,
    val location: String,
    val color: String,
    val bodyType: String,
    val steering: String,
)