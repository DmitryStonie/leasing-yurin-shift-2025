package com.dmitrystonie.leasingapp.leasing.ui.contacts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmitrystonie.leasingapp.carlooking.presentation.car.CarScreenState
import com.dmitrystonie.leasingapp.carlooking.presentation.car.CarViewModel
import com.dmitrystonie.leasingapp.carlooking.ui.car.CarContent
import com.dmitrystonie.leasingapp.carlooking.ui.car.CarError
import com.dmitrystonie.leasingapp.carlooking.ui.car.TopBar
import com.dmitrystonie.leasingapp.component.ui.ProgressIndicator
import com.dmitrystonie.leasingapp.ui.theme.BgPrimary

@Composable
fun LeasingContactsScreen(
    carId: String, onBackClick: () -> Unit, onNextClick: () -> Unit
) {
    val viewModel: CarViewModel =
        hiltViewModel<CarViewModel, CarViewModel.CarViewModelFactory> { factory ->
            factory.create(carId)
        }
    val state by viewModel.state.observeAsState(CarScreenState.Loading)

    val modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    LaunchedEffect(Unit) {
        viewModel.loadCar()
    }

    Column(
        modifier = Modifier.background(BgPrimary)

    ) {
        TopBar(
            onBackClick = onBackClick
        )
        when (val currentState = state) {
            CarScreenState.Initial, CarScreenState.Loading -> ProgressIndicator()

            is CarScreenState.Content -> CarContent(
                modifier = modifier, car = currentState.car,
                onBackClick = onBackClick
            )

            is CarScreenState.Error -> CarError(
                onRetry = { viewModel.loadCar() })
        }


    }

}