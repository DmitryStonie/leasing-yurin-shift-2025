package com.dmitrystonie.leasingapp.leasing.ui.result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmitrystonie.leasingapp.component.ui.CarsTopAppBarWithRightIcon
import com.dmitrystonie.leasingapp.leasing.presentation.BookingViewModel
import com.dmitrystonie.leasingapp.component.theme.BgPrimary
import com.dmitrystonie.leasingapp.component.theme.BorderLight
import com.dmitrystonie.leasingapp.feature.leasing.R
import com.dmitrystonie.leasingapp.component.ui.R as RComponent

@Composable
fun LeasingResultScreen(
    carId: String, onBackClick: () -> Unit, onStatusClick: () -> Unit, onMainClick: () -> Unit
) {
    hiltViewModel<BookingViewModel, BookingViewModel.BookingViewModelFactory> { factory ->
        factory.create(carId)
    }

    Modifier.padding(start = 16.dp, end = 16.dp)

    Column(
        modifier = Modifier.background(BgPrimary)
    ) {
        TopBar(onBackClick)

        ResultMessage()

        StatusField()

        CarField()

        PickupField()

        ReturnField()

        DatesField()

        MessageField()

        StatusButton(onStatusClick)

        MainButton(onMainClick)
    }

}

@Composable
fun TopBar(onClick: () -> Unit) {
    CarsTopAppBarWithRightIcon(
        text = "",
        icon = painterResource(RComponent.drawable.cross),
        iconColor = BorderLight,
        description = stringResource(R.string.leasing_back_description),
        onClick = onClick
    )
}

@Composable
fun MainButton(onClick: () -> Unit) {
    // not completed
}

@Composable
fun StatusButton(onClick: () -> Unit) {
    // not completed
}

@Composable
fun MessageField() {
    // not completed
}

@Composable
fun DatesField() {
    // not completed
}

@Composable
fun ReturnField() {
    // not completed
}

@Composable
fun PickupField() {
    // not completed
}

@Composable
fun CarField() {
    // not completed
}

@Composable
fun StatusField() {
    // not completed
}

@Composable
fun ResultMessage() {
    // not completed
}