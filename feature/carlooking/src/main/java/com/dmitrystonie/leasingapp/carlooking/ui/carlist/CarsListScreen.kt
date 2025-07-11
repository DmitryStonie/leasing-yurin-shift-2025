package com.dmitrystonie.leasingapp.carlooking.ui.carlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmitrystonie.leasingapp.carlooking.presentation.carlist.CarListScreenState
import com.dmitrystonie.leasingapp.carlooking.presentation.carlist.CarListViewModel
import com.dmitrystonie.leasingapp.carlooking.ui.car.CarError
import com.dmitrystonie.leasingapp.component.ui.ProgressIndicator
import com.dmitrystonie.leasingapp.component.theme.BgPrimary


@Composable
fun CarsListScreen(onCarClick: (String) -> Unit, onFiltersClick: () -> Unit) {
    val viewModel = hiltViewModel<CarListViewModel>()
    val state by viewModel.state.observeAsState(CarListScreenState.Loading)

    LaunchedEffect(Unit) {
        viewModel.loadCars()
    }
    Column {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .background(color = BgPrimary)
                .verticalScroll(rememberScrollState())
                .weight(weight = 1f, fill = false)
        ) {
            TopBar()

            SearchField()

            RentDateField()

            FiltersButton(onFiltersClick)

            when (val currentState = state) {
                CarListScreenState.Initial, CarListScreenState.Loading -> ProgressIndicator()

                is CarListScreenState.Content -> CarsList(
                    cars = currentState.cars, onClick = onCarClick,
                )

                is CarListScreenState.Error -> CarError(
                    onRetry = { viewModel.loadCars() })
            }
        }
    }
}


// broken, will be fixed
//@Preview(showBackground = true)
//@Composable
//private fun CarsListScreenPreview() {
//    val carsMock = listOf(
//        SmallCarCardDto(
//            name = "Chery Arrizo 8",
//            specs = "Автомат, 2.5л",
//            priceDay = "5 000 ₽",
//            pricePeriod = "70 000 ₽ за 14 дней",
//            image = painterResource(R.drawable.car_sample)
//        ), SmallCarCardDto(
//            name = "Chery Arrizo 8",
//            specs = "Автомат, 2.5л",
//            priceDay = "5 000 ₽",
//            pricePeriod = "70 000 ₽ за 14 дней",
//            image = painterResource(R.drawable.car_sample)
//        ), SmallCarCardDto(
//            name = "Chery Arrizo 8",
//            specs = "Автомат, 2.5л",
//            priceDay = "5 000 ₽",
//            pricePeriod = "70 000 ₽ за 14 дней",
//            image = painterResource(R.drawable.car_sample)
//        ), SmallCarCardDto(
//            name = "Chery Arrizo 8",
//            specs = "Автомат, 2.5л",
//            priceDay = "5 000 ₽",
//            pricePeriod = "70 000 ₽ за 14 дней",
//            image = painterResource(R.drawable.car_sample)
//        ), SmallCarCardDto(
//            name = "Chery Arrizo 8",
//            specs = "Автомат, 2.5л",
//            priceDay = "5 000 ₽",
//            pricePeriod = "70 000 ₽ за 14 дней",
//            image = painterResource(R.drawable.car_sample)
//        ), SmallCarCardDto(
//            name = "Chery Arrizo 8",
//            specs = "Автомат, 2.5л",
//            priceDay = "5 000 ₽",
//            pricePeriod = "70 000 ₽ за 14 дней",
//            image = painterResource(R.drawable.car_sample)
//        )
//    )
//    CarsListScreen(onCarClick = {}, onFiltersClick = {})
//}