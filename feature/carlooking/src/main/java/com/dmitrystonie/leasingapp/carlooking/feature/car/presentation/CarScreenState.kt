package com.dmitrystonie.leasingapp.carlooking.feature.car.presentation

import com.dmitrystonie.leasingapp.domain.entity.car.Car

sealed interface CarScreenState {

    data object Initial : CarScreenState

    data object Loading : CarScreenState

    data class Content(val car: Car) : CarScreenState

    data class Error(val message: String) : CarScreenState
}