package com.dmitrystonie.leasingapp.component.ui

import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dmitrystonie.leasingapp.R
import com.dmitrystonie.leasingapp.ui.theme.TextPrimary
import com.dmitrystonie.leasingapp.ui.theme.TextSecondary
import com.dmitrystonie.leasingapp.ui.theme.Transparent
import com.dmitrystonie.leasingapp.ui.theme.appFontFamily

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

data class SmallCarCardDto(
    val name: String,
    val specs: String,
    val priceDay: String,
    val pricePeriod: String,
    val image: Painter
)

@Composable
fun CarSmallCard(
    modifier: Modifier = Modifier,
    imagePainter: Painter,
    imageDescription: String,
    smallCarCardDto: SmallCarCardDto,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
            .clickable(true, onClick = onClick)
    ) {
        Image(
            imagePainter, imageDescription,
            modifier = Modifier
                .border(
                    width = 0.dp, color = Transparent, shape = RoundedCornerShape(8.dp)
                )
                .height(116.dp)
                .width(152.dp),
            contentScale = ContentScale.Fit,
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp)
        ) {
            Column {
                Text(
                    text = smallCarCardDto.name, style = titleItemStyle
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = smallCarCardDto.specs,
                    style = subtitleItemStyle
                )
            }
            Column(modifier = Modifier.padding(top = 26.dp)) {
                Text(
                    text = smallCarCardDto.priceDay, style = titleItemStyle
                )
                Text(
                    modifier = Modifier.padding(top = 2.dp),
                    text = smallCarCardDto.pricePeriod,
                    style = subtitleItemStyle
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CarSmallCardPreview() {
    val smallCarCardDto = SmallCarCardDto(
        name = "Chery Arrizo 8",
        specs = "Автомат, 2.5л",
        priceDay = "5 000 ₽",
        pricePeriod = "70 000 ₽ за 14 дней",
        image = painterResource(R.drawable.car_sample)
    )
    CarSmallCard(
        imagePainter = smallCarCardDto.image,
        imageDescription = smallCarCardDto.name,
        smallCarCardDto = smallCarCardDto,
        onClick = {})
}