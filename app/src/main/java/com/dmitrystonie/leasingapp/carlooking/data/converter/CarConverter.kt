package com.dmitrystonie.leasingapp.carlooking.data.converter

import com.dmitrystonie.leasingapp.carlooking.data.datasource.dto.CarDto
import com.dmitrystonie.leasingapp.carlooking.data.datasource.dto.CarWithRentDto
import com.dmitrystonie.leasingapp.domain.entity.car.BodyType
import com.dmitrystonie.leasingapp.domain.entity.car.Brand
import com.dmitrystonie.leasingapp.domain.entity.car.Car
import com.dmitrystonie.leasingapp.domain.entity.car.Color
import com.dmitrystonie.leasingapp.domain.entity.car.Media
import com.dmitrystonie.leasingapp.domain.entity.car.Steering
import com.dmitrystonie.leasingapp.domain.entity.car.Transmission

fun CarDto.toCar(): Car {
    return Car(
        id = this.id,
        name = this.name,
        brand = when (this.brand) {
            Brand.HAVAL.brandName -> Brand.HAVAL
            Brand.HYUNDAI.brandName -> Brand.HYUNDAI
            Brand.VOLKSWAGEN.brandName -> Brand.VOLKSWAGEN
            Brand.KIA.brandName -> Brand.KIA
            Brand.GEELY.brandName -> Brand.GEELY
            Brand.MERCEDES.brandName -> Brand.MERCEDES
            Brand.GARDEN_CAR.brandName -> Brand.GARDEN_CAR
            Brand.GROCERY_CART.brandName -> Brand.GROCERY_CART
            Brand.HAIER.brandName -> Brand.HAIER
            else -> Brand.INVALID
        },
        media = this.media.map { mediaDto ->
            Media(
                url = mediaDto.url, isCover = mediaDto.isCover
            )
        },
        transmission = when(this.transmission){
            Transmission.AUTOMATIC.type -> Transmission.AUTOMATIC
            Transmission.MANUAL.type -> Transmission.MANUAL
            else -> Transmission.OTHER
        },
        price = this.price,
        location = this.location,
        color = when(this.color){
            Color.RED.colorName -> Color.RED
            Color.BLACK.colorName -> Color.BLACK
            Color.WHITE.colorName -> Color.WHITE
            Color.SILVER.colorName -> Color.SILVER
            Color.BLUE.colorName -> Color.BLUE
            Color.GREY.colorName -> Color.GREY
            Color.ORANGE.colorName -> Color.ORANGE
            else -> Color.OTHER
        },
        bodyType = when(this.bodyType){
            BodyType.SEDAN.type -> BodyType.SEDAN
            BodyType.SUV.type -> BodyType.SUV
            BodyType.COUPE.type -> BodyType.COUPE
            BodyType.HATCHBACK.type -> BodyType.HATCHBACK
            BodyType.CABRIOLET.type -> BodyType.CABRIOLET
            else -> BodyType.OTHER
        },
        steering = when(this.steering){
            Steering.LEFT.type -> Steering.LEFT
            Steering.RIGHT.type -> Steering.RIGHT
            else -> Steering.OTHER
        },
    )
}

fun CarWithRentDto.toCar(): Car {
    return Car(
        id = this.id,
        name = this.name,
        brand = when (this.brand) {
            Brand.HAVAL.brandName -> Brand.HAVAL
            Brand.HYUNDAI.brandName -> Brand.HYUNDAI
            Brand.VOLKSWAGEN.brandName -> Brand.VOLKSWAGEN
            Brand.KIA.brandName -> Brand.KIA
            Brand.GEELY.brandName -> Brand.GEELY
            Brand.MERCEDES.brandName -> Brand.MERCEDES
            Brand.GARDEN_CAR.brandName -> Brand.GARDEN_CAR
            Brand.GROCERY_CART.brandName -> Brand.GROCERY_CART
            Brand.HAIER.brandName -> Brand.HAIER
            else -> Brand.INVALID
        },
        media = this.media.map { mediaDto ->
            Media(
                url = mediaDto.url, isCover = mediaDto.isCover
            )
        },
        transmission = when(this.transmission){
            Transmission.AUTOMATIC.type -> Transmission.AUTOMATIC
            Transmission.MANUAL.type -> Transmission.MANUAL
            else -> Transmission.OTHER
        },
        price = this.price,
        location = this.location,
        color = when(this.color){
            Color.RED.colorName -> Color.RED
            Color.BLACK.colorName -> Color.BLACK
            Color.WHITE.colorName -> Color.WHITE
            Color.SILVER.colorName -> Color.SILVER
            Color.BLUE.colorName -> Color.BLUE
            Color.GREY.colorName -> Color.GREY
            Color.ORANGE.colorName -> Color.ORANGE
            else -> Color.OTHER
        },
        bodyType = when(this.bodyType){
            BodyType.SEDAN.type -> BodyType.SEDAN
            BodyType.SUV.type -> BodyType.SUV
            BodyType.COUPE.type -> BodyType.COUPE
            BodyType.HATCHBACK.type -> BodyType.HATCHBACK
            BodyType.CABRIOLET.type -> BodyType.CABRIOLET
            else -> BodyType.OTHER
        },
        steering = when(this.steering){
            Steering.LEFT.type -> Steering.LEFT
            Steering.RIGHT.type -> Steering.RIGHT
            else -> Steering.OTHER
        },
    )
}