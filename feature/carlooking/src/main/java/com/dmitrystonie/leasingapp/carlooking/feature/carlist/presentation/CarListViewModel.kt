package com.dmitrystonie.leasingapp.carlooking.feature.carlist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmitrystonie.leasingapp.domain.usecase.GetCarsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarListViewModel @Inject constructor(
    private val getCarsUseCase: GetCarsUseCase,
) : ViewModel() {

    private val _state = MutableLiveData<CarListScreenState>(CarListScreenState.Initial)
    val state: LiveData<CarListScreenState> = _state

    fun loadCars() {
        if (_state.value is CarListScreenState.Loading || state.value is CarListScreenState.Content) {
            return
        }

        _state.value = CarListScreenState.Loading

        viewModelScope.launch {
            try {
                val cars = getCarsUseCase(null)
                _state.value = CarListScreenState.Content(cars = cars)
            } catch (e: Exception) {
                _state.value = CarListScreenState.Error(message = e.message.orEmpty())
            }
        }
    }

}