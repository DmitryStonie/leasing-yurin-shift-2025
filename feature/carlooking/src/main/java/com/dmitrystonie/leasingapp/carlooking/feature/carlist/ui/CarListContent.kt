package com.dmitrystonie.leasingapp.carlooking.feature.carlist.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.carlooking.feature.car.ui.CarSmallCard
import com.dmitrystonie.leasingapp.component.ui.CarsTopAppBar
import com.dmitrystonie.leasingapp.component.ui.ColouredButtonWithIcon
import com.dmitrystonie.leasingapp.component.ui.InputTextFieldWithTitle
import com.dmitrystonie.leasingapp.domain.entity.car.Car
import com.dmitrystonie.leasingapp.component.theme.IconPrimary
import com.dmitrystonie.leasingapp.component.theme.TextInvert
import com.dmitrystonie.leasingapp.component.theme.TextSecondary
import com.dmitrystonie.leasingapp.feature.carlooking.R
import com.dmitrystonie.leasingapp.component.ui.R as RComponent

@Composable
internal fun TopBar() {
    CarsTopAppBar(
        text = stringResource(R.string.cars_top_app_bar_title),
    )
}

@Composable
internal fun CarsList(cars: List<Car>, onClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(1200.dp),
        userScrollEnabled = true,
        contentPadding = PaddingValues(bottom = 24.dp),
    ) {
        items(cars) { item ->
            CarSmallCard(
                modifier = Modifier.padding(top = 24.dp), car = item, onClick = onClick
            )
        }
    }
}

@Composable
internal fun FiltersButton(onClick: () -> Unit) {
    ColouredButtonWithIcon(
        modifier = Modifier
            .padding(
                top = 24.dp, start = 16.dp, end = 16.dp, bottom = 16.dp
            )
            .fillMaxWidth(),
        onClick = onClick,
        buttonColors = ButtonColors(
            containerColor = TextSecondary,
            contentColor = TextInvert,
            disabledContainerColor = TextSecondary,
            disabledContentColor = TextInvert
        ),
        text = stringResource(R.string.cars_filter_button_title),
        iconPainter = painterResource(RComponent.drawable.sliders),
        iconContentDescription = stringResource((R.string.cars_filter_button_icon_description)),
    )
}

@Composable
internal fun RentDateField() {
    InputTextFieldWithTitle(
        modifier = Modifier
            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth(),
        titleText = stringResource(R.string.cars_rent_date_field_headline),
        fieldText = "",
        placeholderText = stringResource(R.string.cars_rent_date_icon_description),
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
internal fun SearchField() {
    InputTextFieldWithTitle(
        modifier = Modifier
            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth(),
        titleText = stringResource(R.string.cars_search_field_headline),
        fieldText = "",
        placeholderText = stringResource(R.string.cars_search_field_hint),
        onValueChange = {},
    )
}