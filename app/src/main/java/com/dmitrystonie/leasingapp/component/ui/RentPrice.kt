package com.dmitrystonie.leasingapp.component.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.R
import com.dmitrystonie.leasingapp.car.domain.Rent
import com.dmitrystonie.leasingapp.domain.entity.car.BodyType
import com.dmitrystonie.leasingapp.domain.entity.car.Brand
import com.dmitrystonie.leasingapp.domain.entity.car.Car
import com.dmitrystonie.leasingapp.domain.entity.car.Color
import com.dmitrystonie.leasingapp.domain.entity.car.Media
import com.dmitrystonie.leasingapp.domain.entity.car.Steering
import com.dmitrystonie.leasingapp.domain.entity.car.Transmission
import com.dmitrystonie.leasingapp.ui.theme.BorderExtraLight
import com.dmitrystonie.leasingapp.ui.theme.TextSecondary
import com.dmitrystonie.leasingapp.util.dateToDay
import com.dmitrystonie.leasingapp.util.dateToMonth
import com.dmitrystonie.leasingapp.util.dateToYear
import com.dmitrystonie.leasingapp.util.daysDuration

@Composable
fun RentPrice(
    modifier: Modifier = Modifier,
    price: Int,
    rent: Rent,
) {
    Column(modifier = modifier) {
        Subtitle(
            text = stringResource(R.string.cars_card_price_title)
        )
        HorizontalDivider(
            color = BorderExtraLight, modifier = Modifier.padding(vertical = 16.dp)
        )
        PriceTitle(
            modifier = Modifier.padding(bottom = 16.dp), price = price * daysDuration(rent.startDate, rent.endDate)
        )
        Paragraph(
            modifier = Modifier.padding(bottom = 16.dp),
            color = TextSecondary,
            text = stringResource(
                R.string.cars_card_price_dates_title,
                dateToDay(rent.startDate),
                dateToDay(rent.endDate),
                dateToMonth(rent.endDate),
                dateToYear(rent.endDate),
                daysDuration(rent.startDate, rent.endDate)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RentPricePreview() {
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
        rents = listOf(
            Rent(
                startDate = 1717236000000, endDate = 1717610400000
            )
        )
    )
    RentPrice(
        price = 20000, rent = carMock.rents[0]
    )
}