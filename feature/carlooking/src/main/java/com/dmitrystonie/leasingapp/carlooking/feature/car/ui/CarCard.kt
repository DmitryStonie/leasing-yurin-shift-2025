package com.dmitrystonie.leasingapp.carlooking.feature.car.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.dmitrystonie.leasingapp.domain.entity.car.Car
import com.dmitrystonie.leasingapp.component.theme.TextPrimary
import com.dmitrystonie.leasingapp.component.theme.TextSecondary
import com.dmitrystonie.leasingapp.component.theme.Transparent
import com.dmitrystonie.leasingapp.component.theme.appFontFamily
import com.dmitrystonie.leasingapp.car.domain.Rent
import com.dmitrystonie.leasingapp.domain.entity.car.BodyType
import com.dmitrystonie.leasingapp.domain.entity.car.Brand
import com.dmitrystonie.leasingapp.domain.entity.car.Color
import com.dmitrystonie.leasingapp.domain.entity.car.Media
import com.dmitrystonie.leasingapp.domain.entity.car.Steering
import com.dmitrystonie.leasingapp.domain.entity.car.Transmission
import com.dmitrystonie.leasingapp.feature.carlooking.R

val titleItemStyle = TextStyle(
    color = TextPrimary,
    fontSize = 16.sp,
    fontWeight = FontWeight.W500,
    fontFamily = appFontFamily,
    letterSpacing = 0.sp,
    lineHeight = 24.sp,
)

val subtitleItemStyle = TextStyle(
    color = TextSecondary,
    fontSize = 12.sp,
    fontWeight = FontWeight.W400,
    fontFamily = appFontFamily,
    letterSpacing = 0.sp,
    lineHeight = 16.sp,
)

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CarSmallCard(
    modifier: Modifier = Modifier,
    car: Car,
    onClick: (String) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
            .clickable(true, onClick = { onClick(car.id) })
    ) {
        GlideImage(
            model = car.media.first{it.isCover == true}.url, contentDescription = car.name,
            modifier = Modifier
                .border(
                    width = 0.dp, color = Transparent, shape = RoundedCornerShape(8.dp)
                )
                .height(116.dp)
                .width(152.dp),
            contentScale = ContentScale.FillWidth,
            loading = placeholder(R.drawable.placeholder),
            failure = placeholder(R.drawable.placeholder),
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        ) {
            Column {
                Text(
                    text = car.name, style = titleItemStyle
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = car.transmission.type,
                    style = subtitleItemStyle,
                )
            }
            Column(modifier = Modifier.padding(top = 26.dp)) {
                Text(
                    text = stringResource(R.string.cars_card_price_text, car.price), style = titleItemStyle
                )
                Text(
                    modifier = Modifier.padding(top = 2.dp),
                    text = stringResource(R.string.cars_card_price_offer_text, (car.price * 14).toString(), "14"),
                    style = subtitleItemStyle,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CarSmallCardPreview() {
    val carMock = Car(
        id = "1",
        name = "Model X",
        brand = Brand.HAVAL,
        media = listOf(Media(
            url = "/static/images/cars/haval-jolion.webp",
            isCover = true
        )),
        transmission = Transmission.AUTOMATIC,
        price = 15000,
        location = "Москва, ул. Пушкина 10",
        color = Color.BLACK,
        bodyType = BodyType.SEDAN,
        steering = Steering.LEFT,
        rents = listOf(Rent(
            startDate = 1717236000000,
            endDate = 1717610400000
        ))
    )

    CarSmallCard(
        car = carMock,
        onClick = {}
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CarImage(modifier: Modifier = Modifier, url: String?, description: String) {
    GlideImage(
        model = url, contentDescription = description,
        modifier = modifier.border(
                width = 0.dp, color = Transparent, shape = RoundedCornerShape(8.dp)
            ),
        contentScale = ContentScale.Fit,
    )
}