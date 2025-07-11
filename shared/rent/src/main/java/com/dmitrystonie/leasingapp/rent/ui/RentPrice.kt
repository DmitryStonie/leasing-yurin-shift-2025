package com.dmitrystonie.leasingapp.rent.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.component.theme.BorderExtraLight
import com.dmitrystonie.leasingapp.component.theme.TextSecondary
import com.dmitrystonie.leasingapp.component.ui.Paragraph
import com.dmitrystonie.leasingapp.component.ui.PriceTitle
import com.dmitrystonie.leasingapp.component.ui.Subtitle
import com.dmitrystonie.leasingapp.shared.rent.R
import com.dmitrystonie.leasingapp.util.dateToDay
import com.dmitrystonie.leasingapp.util.dateToMonth
import com.dmitrystonie.leasingapp.util.dateToYear
import com.dmitrystonie.leasingapp.util.daysDuration

@Composable
fun RentPrice(
    modifier: Modifier = Modifier, price: Int, startDate: Long, endDate: Long
) {
    Column(modifier = modifier) {
        Subtitle(
            text = stringResource(R.string.rent_price_title)
        )
        HorizontalDivider(
            color = BorderExtraLight, modifier = Modifier.padding(vertical = 16.dp)
        )
        PriceTitle(
            modifier = Modifier.padding(bottom = 16.dp),
            price = price * daysDuration(startDate, endDate)
        )
        Paragraph(
            modifier = Modifier.padding(bottom = 16.dp),
            color = TextSecondary,
            text = stringResource(
                R.string.rent_price_dates_title,
                dateToDay(startDate),
                dateToDay(endDate),
                dateToMonth(endDate),
                dateToYear(endDate),
                daysDuration(startDate, endDate)
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RentPricePreview() {
    RentPrice(
        price = 20000,
        startDate = 1717236000000,
        endDate = 1717610400000,
    )
}