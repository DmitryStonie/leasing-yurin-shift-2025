package com.dmitrystonie.leasingapp.carlooking.data.converter

import android.util.Log
import com.dmitrystonie.leasingapp.BuildConfig
import com.dmitrystonie.leasingapp.car.domain.Rent
import com.dmitrystonie.leasingapp.carlooking.data.datasource.dto.CarWithRentDto
import com.dmitrystonie.leasingapp.domain.entity.car.BodyType
import com.dmitrystonie.leasingapp.domain.entity.car.Brand
import com.dmitrystonie.leasingapp.domain.entity.car.Car
import com.dmitrystonie.leasingapp.domain.entity.car.Color
import com.dmitrystonie.leasingapp.domain.entity.car.Media
import com.dmitrystonie.leasingapp.domain.entity.car.Steering
import com.dmitrystonie.leasingapp.domain.entity.car.Transmission

fun CarWithRentDto.toCar(): Car? {
    try {
        return Car(
            id = this.id,
            name = this.name,
            brand = convertBrand(),
            media = convertMedia(),
            transmission = convertTransmission(),
            price = this.price,
            location = this.location,
            color = convertColor(),
            bodyType = convertBodyType(),
            steering = convertSteering(),
            rents = convertRents(),
        )
    } catch(e : Exception){
        Log.d("ERROR", "Got exception ${e.message}")
        return null
    }
}

private fun CarWithRentDto.convertRents(): List<Rent> {
    return if (this.rents != null) this.rents.map { rent ->
        Rent(
            rent.startDate,
            rent.endDate
        )
    } else listOf()
}

private fun CarWithRentDto.convertSteering(): Steering {
    return when (this.steering) {
        Steering.LEFT.type -> Steering.LEFT
        Steering.RIGHT.type -> Steering.RIGHT
        else -> throw Exception("Invalid CarDto")
    }
}

private fun CarWithRentDto.convertBodyType(): BodyType {
    return when (this.bodyType) {
        BodyType.SEDAN.type -> BodyType.SEDAN
        BodyType.SUV.type -> BodyType.SUV
        BodyType.COUPE.type -> BodyType.COUPE
        BodyType.HATCHBACK.type -> BodyType.HATCHBACK
        BodyType.CABRIOLET.type -> BodyType.CABRIOLET
        else -> throw Exception("Invalid CarDto")
    }
}

private fun CarWithRentDto.convertColor(): Color {
    return when (this.color) {
        Color.RED.colorName -> Color.RED
        Color.BLACK.colorName -> Color.BLACK
        Color.WHITE.colorName -> Color.WHITE
        Color.SILVER.colorName -> Color.SILVER
        Color.BLUE.colorName -> Color.BLUE
        Color.GREY.colorName -> Color.GREY
        Color.ORANGE.colorName -> Color.ORANGE
        else -> throw Exception("Invalid CarDto")
    }
}

private fun CarWithRentDto.convertTransmission(): Transmission {
    return when (this.transmission) {
        Transmission.AUTOMATIC.type -> Transmission.AUTOMATIC
        Transmission.MANUAL.type -> Transmission.MANUAL
        else -> throw Exception("Invalid CarDto")
    }
}

private fun CarWithRentDto.convertMedia(): List<Media> {
    return this.media.map { mediaDto ->
        Media(
            url = "${BuildConfig.LEASING_IMAGES_BASE_URL}${mediaDto.url}", isCover = mediaDto.isCover
        )
    }
}

private fun CarWithRentDto.convertBrand(): Brand {
    return when (this.brand) {
        Brand.HAVAL.brandName -> Brand.HAVAL
        Brand.HYUNDAI.brandName -> Brand.HYUNDAI
        Brand.VOLKSWAGEN.brandName -> Brand.VOLKSWAGEN
        Brand.KIA.brandName -> Brand.KIA
        Brand.GEELY.brandName -> Brand.GEELY
        Brand.MERCEDES.brandName -> Brand.MERCEDES
        Brand.GARDEN_CAR.brandName -> Brand.GARDEN_CAR
        Brand.GROCERY_CART.brandName -> Brand.GROCERY_CART
        Brand.HAIER.brandName -> Brand.HAIER
        else -> throw Exception("Invalid CarDto")
    }
}