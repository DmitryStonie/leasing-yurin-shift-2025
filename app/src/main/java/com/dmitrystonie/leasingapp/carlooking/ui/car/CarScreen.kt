package com.dmitrystonie.leasingapp.carlooking.ui.car

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmitrystonie.leasingapp.car.domain.Rent
import com.dmitrystonie.leasingapp.carlooking.presentation.car.CarScreenState
import com.dmitrystonie.leasingapp.carlooking.presentation.car.CarViewModel
import com.dmitrystonie.leasingapp.component.ui.ProgressIndicator
import com.dmitrystonie.leasingapp.domain.entity.car.BodyType
import com.dmitrystonie.leasingapp.domain.entity.car.Brand
import com.dmitrystonie.leasingapp.domain.entity.car.Car
import com.dmitrystonie.leasingapp.domain.entity.car.Color
import com.dmitrystonie.leasingapp.domain.entity.car.Media
import com.dmitrystonie.leasingapp.domain.entity.car.Steering
import com.dmitrystonie.leasingapp.domain.entity.car.Transmission
import com.dmitrystonie.leasingapp.ui.theme.BgPrimary

@Composable
fun CarScreen(
    carId: String, onBackClick: () -> Unit, onBookClick: () -> Unit
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
                onBackClick = onBackClick,
                onBookClick = onBookClick
            )

            is CarScreenState.Error -> CarError(
                onRetry = { viewModel.loadCar() })
        }


    }

}

@Preview(showBackground = true)
@Composable
fun CarScreenPreview() {
    val carMock = Car(
        id = "1",
        name = "Model X",
        brand = Brand.HAVAL,
        media = listOf(
            Media(
                url = "/static/images/cars/haval-jolion.webp", isCover = true
            )
        ),
        transmission = Transmission.AUTOMATIC,
        price = 15000,
        location = "Москва, ул. Пушкина 10",
        color = Color.BLACK,
        bodyType = BodyType.SEDAN,
        steering = Steering.LEFT,
        rents = listOf(Rent(
            startDate = 1717236000000,
            endDate = 1717610400000
        ))
    )
    Column(
        modifier = Modifier.background(BgPrimary)
    ) {
        TopBar(
            onBackClick = { })
        CarContent(
            car = carMock,
            onBackClick = {},
            onBookClick = {},
        )
    }

}