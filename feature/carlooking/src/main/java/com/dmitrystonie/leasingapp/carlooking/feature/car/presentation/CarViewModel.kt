package com.dmitrystonie.leasingapp.carlooking.feature.car.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dmitrystonie.leasingapp.domain.usecase.GetCarUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = CarViewModel.CarViewModelFactory::class)
class CarViewModel @AssistedInject constructor(
    private val getCarUseCase: GetCarUseCase,
    @Assisted private val carId: String,
) : ViewModel() {

    private val _state = MutableLiveData<CarScreenState>(CarScreenState.Initial)
    val state: LiveData<CarScreenState> = _state

    fun loadCar() {
        if (_state.value is CarScreenState.Loading || state.value is CarScreenState.Content) {
            return
        }

        _state.value = CarScreenState.Loading

        viewModelScope.launch {
            try {
                val car = getCarUseCase(carId)
                _state.value = CarScreenState.Content(car = car)
            } catch (e: Exception) {
                _state.value = CarScreenState.Error(message = e.message.orEmpty())
            }
        }
    }

    @AssistedFactory
    interface CarViewModelFactory {
        fun create(carId: String): CarViewModel
    }
}