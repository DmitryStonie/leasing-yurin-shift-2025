package com.dmitrystonie.leasingapp.leasing.ui.booking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmitrystonie.leasingapp.R
import com.dmitrystonie.leasingapp.component.ui.CarsTopAppBarWithLeftIcon
import com.dmitrystonie.leasingapp.component.ui.ColouredButton
import com.dmitrystonie.leasingapp.component.ui.InputTextFieldWithTitle
import com.dmitrystonie.leasingapp.component.ui.LineProgressIndicator
import com.dmitrystonie.leasingapp.leasing.presentation.BookingViewModel
import com.dmitrystonie.leasingapp.component.theme.BgBrand
import com.dmitrystonie.leasingapp.component.theme.BgPrimary
import com.dmitrystonie.leasingapp.component.theme.BorderLight
import com.dmitrystonie.leasingapp.component.theme.IconPrimary
import com.dmitrystonie.leasingapp.component.theme.TextInvert
import com.dmitrystonie.leasingapp.component.ui.R as RComponent

@Composable
fun LeasingBookingScreen(
    carId: String, onBackClick: () -> Unit, onNextClick: () -> Unit
) {
    val viewModel: BookingViewModel =
        hiltViewModel<BookingViewModel, BookingViewModel.BookingViewModelFactory> { factory ->
            factory.create(carId)
        }

    val modifier = Modifier.padding(start = 16.dp, end = 16.dp)

    Column(
        modifier = Modifier.background(BgPrimary), verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopBar(
            onClick = onBackClick
        )

        Indicator(
            modifier = modifier.padding(top = 24.dp)
        )

        DatesField(modifier = modifier.padding(top = 16.dp))

        PickupField(modifier = modifier.padding(top = 16.dp))

        ReturnField(modifier = modifier.padding(top = 16.dp))

        NextButton(
            onClick = onNextClick, modifier = modifier
                .padding(bottom = 24.dp)
                .weight(1f)
        )

    }

}

@Composable
fun TopBar(modifier: Modifier = Modifier, onClick: () -> Unit) {
    CarsTopAppBarWithLeftIcon(
        modifier = modifier,
        text = stringResource(R.string.leasing_screen_step_1_title),
        icon = painterResource(R.drawable.ic_left),
        iconColor = BorderLight,
        description = stringResource(R.string.leasing_back_description),
        onClick = onClick
    )
}

@Composable
fun NextButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    ColouredButton(
        modifier = modifier,
        onClick = onClick,
        buttonColors = ButtonColors(
            containerColor = BgBrand,
            contentColor = TextInvert,
            disabledContainerColor = BgBrand,
            disabledContentColor = TextInvert
        ),
        text = stringResource(R.string.leasing_continue_button_text),
    )
}

@Composable
fun ReturnField(modifier: Modifier = Modifier) {
    InputTextFieldWithTitle(
        modifier = modifier,
        titleText = stringResource(R.string.leasing_place_of_return_headline),
        fieldText = "",
        placeholderText = stringResource(R.string.leasing_place_of_return_placeholder),
        onValueChange = {},
    )
}

@Composable
fun PickupField(modifier: Modifier = Modifier) {
    InputTextFieldWithTitle(
        modifier = modifier,
        titleText = stringResource(R.string.leasing_place_of_receipt_headline),
        fieldText = "",
        placeholderText = stringResource(R.string.leasing_place_of_receipt_placeholder),
        onValueChange = {},
    )
}

@Composable
fun DatesField(modifier: Modifier = Modifier) {
    InputTextFieldWithTitle(
        modifier = modifier,
        titleText = stringResource(R.string.leasing_date_headline),
        fieldText = "",
        placeholderText = stringResource(R.string.leasing_date_placeholder),
        onValueChange = {},
        trailingIcon = {
            Icon(
                painter = painterResource(RComponent.drawable.calendar),
                tint = IconPrimary,
                contentDescription = stringResource(RComponent.string.leasing_edit_data_description)
            )
        },
    )
}

@Composable
fun Indicator(modifier: Modifier = Modifier) {
    LineProgressIndicator(
        modifier = modifier,
        progress = 0.33f,
        title = stringResource(R.string.leasing_step_text, 1, 3)
    )
}

@Preview(showBackground = true)
@Composable
fun LeasingBookingScreenPreview() {
    val modifier = Modifier.padding(start = 16.dp, end = 16.dp)

    Column(
        modifier = Modifier.background(BgPrimary), verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopBar(
            onClick = {})

        Indicator(
            modifier = modifier.padding(top = 24.dp)
        )

        DatesField(modifier = modifier.padding(top = 16.dp))

        PickupField(modifier = modifier.padding(top = 16.dp))

        ReturnField(modifier = modifier.padding(top = 16.dp))
        Spacer(modifier = Modifier.weight(1f))
        NextButton(
            onClick = {}, modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

    }
}
