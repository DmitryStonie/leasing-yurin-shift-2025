package com.dmitrystonie.leasingapp.carlooking.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.R
import com.dmitrystonie.leasingapp.component.ui.CarSmallCard
import com.dmitrystonie.leasingapp.component.ui.CarsBottomAppBar
import com.dmitrystonie.leasingapp.component.ui.CarsTopAppBar
import com.dmitrystonie.leasingapp.component.ui.ColouredButtonWithIcon
import com.dmitrystonie.leasingapp.component.ui.InputTextFieldWithTitle
import com.dmitrystonie.leasingapp.component.ui.SmallCarCardDto
import com.dmitrystonie.leasingapp.ui.theme.BgPrimary
import com.dmitrystonie.leasingapp.ui.theme.IconPrimary
import com.dmitrystonie.leasingapp.ui.theme.TextInvert
import com.dmitrystonie.leasingapp.ui.theme.TextSecondary


@Composable
fun CarsListScreen(cars: List<SmallCarCardDto>) {
    Scaffold(
        topBar = {
            CarsTopAppBar(
                text = stringResource(R.string.cars_top_app_bar_title),
            )
        },
        bottomBar = { CarsBottomAppBar() },
        containerColor = BgPrimary,
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(it)
        ) {
            InputTextFieldWithTitle(
                modifier = Modifier
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp).fillMaxWidth(),
                titleText = stringResource(R.string.cars_search_field_headline),
                fieldText = "",
                placeholderText = stringResource(R.string.cars_search_field_hint),
                onValueChange = {},
            )
            InputTextFieldWithTitle(
                modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp).fillMaxWidth(),
                titleText = stringResource(R.string.cars_rent_date_field_headline),
                fieldText = "",
                placeholderText = stringResource(R.string.cars_rent_date_icon_description),
                onValueChange = {},
                trailingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.calendar),
                        tint = IconPrimary,
                        contentDescription = stringResource(R.string.leasing_edit_data_description)
                    )
                },
            )
            ColouredButtonWithIcon(
                modifier = Modifier.padding(
                    top = 24.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                ).align(Alignment.CenterHorizontally).fillMaxWidth(),
                onClick = {},
                buttonColors = ButtonColors(
                    containerColor = TextSecondary,
                    contentColor = TextInvert,
                    disabledContainerColor = TextSecondary,
                    disabledContentColor = TextInvert
                ),
                text = stringResource(R.string.cars_filter_button_title),
                iconPainter = painterResource(R.drawable.sliders),
                iconContentDescription = stringResource((R.string.cars_filter_button_icon_description)),
            )
        LazyColumn(
            modifier = Modifier.fillMaxSize(), userScrollEnabled = true,
            contentPadding = PaddingValues(bottom = 24.dp),
        ) {
            items(cars) { item ->
                CarSmallCard(
                    modifier = Modifier.padding(top = 24.dp),
                    imagePainter = item.image,
                    imageDescription = item.name,
                    smallCarCardDto = item,
                    onClick = {})
            }
        }
            Text("", modifier = Modifier.padding(it))
        }
    }
}

@Composable
fun Text(x0: String) {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun CarsListScreenPreview() {
    val carsMock = listOf(
        SmallCarCardDto(
            name = "Chery Arrizo 8",
            specs = "Автомат, 2.5л",
            priceDay = "5 000 ₽",
            pricePeriod = "70 000 ₽ за 14 дней",
            image = painterResource(R.drawable.car_sample)
        ), SmallCarCardDto(
            name = "Chery Arrizo 8",
            specs = "Автомат, 2.5л",
            priceDay = "5 000 ₽",
            pricePeriod = "70 000 ₽ за 14 дней",
            image = painterResource(R.drawable.car_sample)
        ), SmallCarCardDto(
            name = "Chery Arrizo 8",
            specs = "Автомат, 2.5л",
            priceDay = "5 000 ₽",
            pricePeriod = "70 000 ₽ за 14 дней",
            image = painterResource(R.drawable.car_sample)
        ), SmallCarCardDto(
            name = "Chery Arrizo 8",
            specs = "Автомат, 2.5л",
            priceDay = "5 000 ₽",
            pricePeriod = "70 000 ₽ за 14 дней",
            image = painterResource(R.drawable.car_sample)
        ), SmallCarCardDto(
            name = "Chery Arrizo 8",
            specs = "Автомат, 2.5л",
            priceDay = "5 000 ₽",
            pricePeriod = "70 000 ₽ за 14 дней",
            image = painterResource(R.drawable.car_sample)
        ), SmallCarCardDto(
            name = "Chery Arrizo 8",
            specs = "Автомат, 2.5л",
            priceDay = "5 000 ₽",
            pricePeriod = "70 000 ₽ за 14 дней",
            image = painterResource(R.drawable.car_sample)
        )
    )
    CarsListScreen(cars = carsMock)
}