package com.dmitrystonie.leasingapp.carlooking.ui.car

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.car.domain.Rent
import com.dmitrystonie.leasingapp.component.ui.BigTitle
import com.dmitrystonie.leasingapp.carlooking.ui.CarImage
import com.dmitrystonie.leasingapp.component.ui.CarsTopAppBarWithLeftIcon
import com.dmitrystonie.leasingapp.component.ui.ColouredButton
import com.dmitrystonie.leasingapp.component.ui.Specs
import com.dmitrystonie.leasingapp.domain.entity.car.Car
import com.dmitrystonie.leasingapp.component.theme.BgBrand
import com.dmitrystonie.leasingapp.component.theme.BgPrimary
import com.dmitrystonie.leasingapp.component.theme.BorderLight
import com.dmitrystonie.leasingapp.component.theme.IndicatorLight
import com.dmitrystonie.leasingapp.component.theme.TextInvert
import com.dmitrystonie.leasingapp.component.theme.TextSecondary
import com.dmitrystonie.leasingapp.feature.carlooking.R
import com.dmitrystonie.leasingapp.rent.ui.RentPrice
import com.dmitrystonie.leasingapp.component.ui.R as RComponent

@Composable
internal fun CarContent(
    modifier: Modifier = Modifier, car: Car, onBackClick: () -> Unit, onBookClick: () -> Unit
) {
    CarImages(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
            .heightIn(
                min = 0.dp, max = 220.dp
            ), url = car.media.find { it.isCover == true }?.url, description = car.name
    )
    CarTitle(
        modifier = modifier.padding(top = 32.dp, bottom = 16.dp), text = car.name
    )
    CarSpecs(
        modifier = modifier, car = car
    )
    Price(
        modifier = modifier.padding(top = 24.dp), car = car
    )
    BackButton(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp), onClick = onBackClick
    )
    RentButton(modifier = modifier.fillMaxWidth(), onClick = onBookClick)
}

@Composable
internal fun RentButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    ColouredButton(
        modifier = modifier,
        onClick = onClick,
        buttonColors = ButtonColors(
            containerColor = BgBrand,
            contentColor = TextInvert,
            disabledContainerColor = BgBrand,
            disabledContentColor = TextInvert
        ),
        text = stringResource(R.string.cars_card_rent_button_title),
    )
}

@Composable
internal fun BackButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    ColouredButton(
        modifier = modifier,
        onClick = onClick,
        buttonColors = ButtonColors(
            containerColor = BgPrimary,
            contentColor = TextSecondary,
            disabledContainerColor = BgPrimary,
            disabledContentColor = TextSecondary
        ),
        text = stringResource(R.string.cars_card_back_button_title),
        border = BorderStroke(1.dp, BorderLight)
    )
}

@Composable
internal fun Price(
    modifier: Modifier = Modifier,
    car: Car,
) {
    val MILLISECONDS_IN_DAY = 86400000
    val FOURTEEN_DAYS_STUB = 14 * MILLISECONDS_IN_DAY
    RentPrice(
        modifier = modifier,
        price = car.price,
        startDate = System.currentTimeMillis(),
        endDate = System.currentTimeMillis() + FOURTEEN_DAYS_STUB
    )
}

@Composable
internal fun CarSpecs(modifier: Modifier = Modifier, car: Car) {
    val specs = listOf(
        Pair(stringResource(R.string.cars_card_transmission_title), car.transmission.type),
        Pair(stringResource(R.string.cars_card_steering_title), car.steering.type),
        Pair(stringResource(R.string.cars_card_body_type_title), car.bodyType.type),
        Pair(stringResource(R.string.cars_card_color_title), car.color.colorName),
    )
    Specs(
        modifier = modifier,
        title = stringResource(R.string.cars_card_characteristics_title),
        specs = specs
    )
}

@Composable
internal fun CarTitle(modifier: Modifier = Modifier, text: String) {
    BigTitle(
        modifier = modifier, text = text
    )
}

@Composable
internal fun CarImages(modifier: Modifier = Modifier, url: String?, description: String) {
    CarImage(
        modifier = modifier,
        url = url,
        description = description,
    )
}

@Composable
internal fun TopBar(onBackClick: () -> Unit) {
    CarsTopAppBarWithLeftIcon(
        text = stringResource(R.string.cars_top_app_bar_title),
        icon = painterResource(RComponent.drawable.ic_left),
        iconColor = IndicatorLight,
        description = stringResource(R.string.ic_left_icon_description),
        onClick = onBackClick
    )
}