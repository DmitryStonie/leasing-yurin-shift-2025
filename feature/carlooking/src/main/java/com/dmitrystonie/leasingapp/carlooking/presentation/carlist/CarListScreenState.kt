package com.dmitrystonie.leasingapp.carlooking.presentation.carlist

import com.dmitrystonie.leasingapp.domain.entity.car.Car

sealed interface CarListScreenState {

    data object Initial : CarListScreenState

    data object Loading : CarListScreenState

    data class Content(val cars: List<Car>) : CarListScreenState

    data class Error(val message: String) : CarListScreenState
}