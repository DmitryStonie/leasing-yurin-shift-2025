package com.dmitrystonie.leasingapp.leasing.presentation

import com.dmitrystonie.leasingapp.domain.entity.rent.Rent


sealed interface BookingState {

    data object Initial : BookingState

    data object Loading : BookingState

    data class Error(val message: String) : BookingState

    data class Success(val rent: Rent) : BookingState
}