package com.dmitrystonie.leasingapp.carlooking.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.R
import com.dmitrystonie.leasingapp.component.ui.BigTitle
import com.dmitrystonie.leasingapp.component.ui.CarImage
import com.dmitrystonie.leasingapp.component.ui.CarsTopAppBarWithLeftIcon
import com.dmitrystonie.leasingapp.component.ui.ColouredButton
import com.dmitrystonie.leasingapp.component.ui.RentPrice
import com.dmitrystonie.leasingapp.component.ui.Specs
import com.dmitrystonie.leasingapp.ui.theme.BgBrand
import com.dmitrystonie.leasingapp.ui.theme.BgPrimary
import com.dmitrystonie.leasingapp.ui.theme.BorderLight
import com.dmitrystonie.leasingapp.ui.theme.IndicatorLight
import com.dmitrystonie.leasingapp.ui.theme.TextInvert
import com.dmitrystonie.leasingapp.ui.theme.TextSecondary

@Composable
fun CarScreen(
    carImage: Painter,
    carName: String,
    specs: List<Pair<String, String>>,
    price: Int,
    rentFrom: Int,
    rentTo: Int,
    rentMonth: String,
    rentYear: Int,
    rentLength: Int
) {
    val modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    Column(
        modifier = Modifier
            .background(BgPrimary)

    ) {
        TopBar()
        CarImages(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            painter = carImage,
            description = carName
        )
        CarTitle(
            modifier = modifier.padding(top = 32.dp), text = carName
        )
        CarSpecs(
            modifier = modifier, specs = specs
        )
        Price(
            modifier = modifier.padding(top = 24.dp),
            price = price,
            rentFrom = rentFrom,
            rentTo = rentTo,
            rentMonth = rentMonth,
            rentYear = rentYear,
            rentLength = rentLength
        )
        BackButton(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        RentButton(modifier = modifier.fillMaxWidth())

    }

}

@Composable
private fun RentButton(modifier: Modifier = Modifier) {
    ColouredButton(
        modifier = modifier,
        onClick = {},
        buttonColors = ButtonColors(
            containerColor = BgBrand,
            contentColor = TextInvert,
            disabledContainerColor = BgBrand,
            disabledContentColor = TextInvert
        ),
        text = stringResource(R.string.cars_card_rent_title),
    )
}

@Composable
private fun BackButton(modifier: Modifier = Modifier) {
    ColouredButton(
        modifier = modifier,
        onClick = {},
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
private fun Price(
    modifier: Modifier = Modifier,
    price: Int,
    rentFrom: Int,
    rentTo: Int,
    rentMonth: String,
    rentYear: Int,
    rentLength: Int
) {
    RentPrice(
        modifier = modifier,
        price = price,
        rentFrom = rentFrom,
        rentTo = rentTo,
        rentMonth = rentMonth,
        rentYear = rentYear,
        rentLength = rentLength
    )
}

@Composable
private fun CarSpecs(modifier: Modifier = Modifier, specs: List<Pair<String, String>>) {
    Specs(
        modifier = modifier,
        title = stringResource(R.string.cars_card_characteristics_title),
        specs = specs
    )
}

@Composable
private fun CarTitle(modifier: Modifier = Modifier, text: String) {
    BigTitle(
        modifier = modifier, text = text
    )
}

@Composable
private fun CarImages(modifier: Modifier = Modifier, painter: Painter, description: String) {
    CarImage(
        modifier = modifier,
        painter = painter,
        description = description,
    )
}

@Composable
private fun TopBar() {
    CarsTopAppBarWithLeftIcon(
        text = stringResource(R.string.cars_top_app_bar_title),
        icon = painterResource(R.drawable.ic_left),
        iconColor = IndicatorLight,
        description = stringResource(R.string.ic_left_icon_description),
        onClick = {})
}

@Preview(showBackground = true)
@Composable
fun CarScreenPreview() {
    val specs = listOf(
        Pair("Коробка передач", "Автоматическая"),
        Pair("Сторона руля", "Слева"),
        Pair("Тип кузова", "Кроссовер"),
        Pair("Цвет", "Чёрный"),
    )
    CarScreen(
        carImage = painterResource(R.drawable.car_sample),
        carName = "Chery Arrizo 8",
        specs = specs,
        price = 35000,
        rentFrom = 10,
        rentTo = 24,
        rentMonth = "апреля",
        rentYear = 2025,
        rentLength = 14
    )
}