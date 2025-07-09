package com.dmitrystonie.leasingapp.leasing.data.converter

import com.dmitrystonie.leasingapp.domain.entity.rent.Rent
import com.dmitrystonie.leasingapp.domain.entity.rent.RentStatus
import com.dmitrystonie.leasingapp.leasing.data.datasource.dto.RentDto

fun RentDto.toRent(): Rent {
    return Rent(
        carId = this.carId,
        status = when (this.status) {
            RentStatus.CREATED.value -> RentStatus.CREATED
            RentStatus.CANCELLED.value -> RentStatus.CANCELLED
            else -> RentStatus.CANCELLED
        },
        pickupLocation = this.pickupLocation,
        returnLocation = this.returnLocation,
        startDate = this.startDate,
        endDate = this.endDate,
        totalPrice = this.totalPrice,
        firstName = this.firstName,
        lastName = this.lastName,
        middleName = this.middleName,
        birthDate = this.birthDate,
        email = this.email,
        phone = this.phone,
        comment = this.comment
    )
}