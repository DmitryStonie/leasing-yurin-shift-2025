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
import com.dmitrystonie.leasingapp.ui.theme.BorderExtraLight
import com.dmitrystonie.leasingapp.ui.theme.TextSecondary

@Composable
fun RentPrice(
    modifier: Modifier = Modifier,
    price: Int,
    rentFrom: Int,
    rentTo: Int,
    rentMonth: String,
    rentYear: Int,
    rentLength: Int
) {
    Column(modifier = modifier) {
        Subtitle(
            text = stringResource(R.string.cars_card_price_title)
        )
        HorizontalDivider(
            color = BorderExtraLight, modifier = Modifier.padding(vertical = 16.dp)
        )
        PriceTitle(
            modifier = Modifier.padding(bottom = 16.dp), price = price
        )
        Paragraph(
            modifier = Modifier.padding(bottom = 16.dp),
            color = TextSecondary,
            text = stringResource(
                R.string.cars_card_price_dates_title,
                rentFrom,
                rentTo,
                rentMonth,
                rentYear,
                rentLength
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RentPricePreview() {
    RentPrice(
        price = 35000,
        rentFrom = 10,
        rentTo = 24,
        rentMonth = "апреля",
        rentYear = 2025,
        rentLength = 14
    )
}