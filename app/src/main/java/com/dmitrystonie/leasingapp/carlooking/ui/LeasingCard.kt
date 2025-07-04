package com.dmitrystonie.leasingapp.carlooking.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dmitrystonie.leasingapp.R
import com.dmitrystonie.leasingapp.ui.theme.BgBrand
import com.dmitrystonie.leasingapp.ui.theme.BgPrimary
import com.dmitrystonie.leasingapp.ui.theme.BgSecondary
import com.dmitrystonie.leasingapp.ui.theme.BorderExtraLight
import com.dmitrystonie.leasingapp.ui.theme.IndicatorAttention
import com.dmitrystonie.leasingapp.ui.theme.IndicatorMedium
import com.dmitrystonie.leasingapp.ui.theme.TextPrimary
import com.dmitrystonie.leasingapp.ui.theme.TextQuartenery
import com.dmitrystonie.leasingapp.ui.theme.TextTertiary
import com.dmitrystonie.leasingapp.ui.theme.appFontFamily

private val cardTitleTextStyle = TextStyle(
    color = TextPrimary,
    fontSize = 16.sp,
    fontWeight = FontWeight.W500,
    fontFamily = appFontFamily,
    letterSpacing = 0.sp,
    lineHeight = 24.sp,
)

private val smallTitleStyle = TextStyle(
    color = TextTertiary,
    fontSize = 12.sp,
    fontWeight = FontWeight.W400,
    fontFamily = appFontFamily,
    letterSpacing = 0.sp,
    lineHeight = 16.sp,
)

private val textStyle = TextStyle(
    color = TextPrimary,
    fontSize = 16.sp,
    fontWeight = FontWeight.W400,
    fontFamily = appFontFamily,
    letterSpacing = 0.sp,
    lineHeight = 24.sp,
)

private val moreInfoTextStyle = TextStyle(
    color = TextQuartenery,
    fontSize = 14.sp,
    fontWeight = FontWeight.W400,
    fontFamily = appFontFamily,
    letterSpacing = 0.sp,
    lineHeight = 20.sp,
    textDecoration = TextDecoration.Underline,
)

data class CardItemDto(
    val title: String, val text: String
)

data class StatusItemDto(
    val title: String, val text: String, val statusColor: Color, val statusDescription: String
)

data class BorderCardDto(
    val firstTitle: String,
    val secondTitle: String,
    val firstItems: List<CardItemDto>,
    val secondItems: List<CardItemDto>,
    val status: StatusItemDto,
    val buttonText: String,
    val buttonOnClick: () -> Unit,
    val buttonColors: ButtonColors,
)

data class MoreInfoDto(
    val text: String,
    val onClick: () -> Unit,
)

data class BorderlessCardDto(
    val items: List<CardItemDto>, val status: StatusItemDto, val moreInfo: MoreInfoDto
)


@Composable
fun ColouredCard(onTitleClick: () -> Unit, title: String, items: List<CardItemDto>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = BgSecondary, shape = RoundedCornerShape(24.dp))
    ) {
        CardTitleWithIcon(
            onClick = onTitleClick,
            text = title,
            modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp)
        )
        items.mapIndexed { index, item ->
            if (index != items.lastIndex) {
                CardComponent(
                    title = item.title,
                    text = item.text,
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )
            } else {
                CardComponent(
                    title = item.title, text = item.text, modifier = Modifier.padding(
                        top = 16.dp, bottom = 24.dp, start = 16.dp, end = 16.dp
                    )
                )
            }
        }
    }
}


@Composable
fun CardTitle(modifier: Modifier = Modifier, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CardTitleText(
            text = text
        )
    }
}

@Composable
fun CardTitleWithIcon(modifier: Modifier = Modifier, onClick: () -> Unit, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CardTitleText(
            text = text
        )
        Icon(
            painter = painterResource(R.drawable.edit),
            contentDescription = stringResource(R.string.leasing_edit_data_description),
            modifier = Modifier
                .size(24.dp)
                .clickable(true) { onClick() },
            tint = IndicatorMedium,
        )
    }
}

@Composable
fun CardTitleText(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text, modifier = modifier, maxLines = 1, style = cardTitleTextStyle
    )
}

@Composable
fun CardComponent(modifier: Modifier = Modifier, title: String, text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {
        CardSmallTitle(title)
        CardText(text)
    }
}

@Composable
fun CardStatusComponent(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    statusColor: Color,
    statusDescription: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {
        CardSmallTitle(title)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(R.drawable.indicator),
                contentDescription = statusDescription,
                tint = statusColor,
                modifier = Modifier.padding(end = 12.dp)
            )
            CardText(text)
        }
    }
}

@Composable
fun CardSmallTitle(text: String) {
    Text(
        modifier = Modifier.padding(bottom = 2.dp), text = text, style = smallTitleStyle
    )
}

@Composable
fun CardText(text: String) {
    Text(
        text = text, style = textStyle
    )
}

@Composable
fun BorderCard(
    borderCardDto: BorderCardDto
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = BgPrimary)
            .border(
                width = 1.dp, color = BorderExtraLight, shape = RoundedCornerShape(24.dp)
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CardTitle(
            text = borderCardDto.firstTitle,
            modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp)
        )
        CardStatusComponent(
            modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp),
            title = borderCardDto.status.title,
            text = borderCardDto.status.text,
            statusColor = borderCardDto.status.statusColor,
            statusDescription = borderCardDto.status.statusDescription
        )
        borderCardDto.firstItems.mapIndexed { index, item ->
            CardComponent(
                title = item.title,
                text = item.text,
                modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp)
            )
        }
        CardTitle(
            text = borderCardDto.secondTitle,
            modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp)
        )
        borderCardDto.secondItems.mapIndexed { index, item ->
            CardComponent(
                title = item.title,
                text = item.text,
                modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp)
            )
        }
        ColouredButton(
            modifier = Modifier.padding(
                horizontal = 16.dp, vertical = 24.dp
            ),
            onClick = borderCardDto.buttonOnClick,
            buttonColors = borderCardDto.buttonColors,
            text = borderCardDto.buttonText
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BorderCardPreview(onTitleClick: () -> Unit = {}, title: String = "Данные брони") {
    val firstItemsMock: List<CardItemDto> = listOf(
        CardItemDto("Автомобиль", "Chery Arrizo 8"),
        CardItemDto("Место получения", "Место получения"),
        CardItemDto("Место возврата", "Место возврата"),
        CardItemDto("Даты брони", "01.04.2025 - 08.04.2025"),
    )
    val secondItemsMock: List<CardItemDto> = listOf(
        CardItemDto("ФИО", "Иванов Иван Иванович"),
        CardItemDto("Дата рождения", "01.01.1980"),
        CardItemDto("Номер телефона", "+7 913 123 45 67"),
        CardItemDto("Электронная почта", "ivanov.ivan@gmail.com"),
        CardItemDto("Комментарий", "Положить пачку влажных салфеток в бардачок"),
    )
    val borderCardDtoMock = BorderCardDto(
        firstTitle = "Данные брони",
        secondTitle = "Данные заказчика",
        firstItems = firstItemsMock,
        secondItems = secondItemsMock,
        status = StatusItemDto(
            title = "Статус",
            text = "Создана",
            statusColor = IndicatorAttention,
            statusDescription = "Описание статуса"
        ),
        buttonText = "Отменить бронь",
        buttonOnClick = {},
        buttonColors = ButtonColors(
            containerColor = BgBrand,
            contentColor = BgPrimary,
            disabledContainerColor = BgBrand,
            disabledContentColor = BgPrimary
        )
    )
    BorderCard(borderCardDtoMock)
}

@Composable
fun MoreInfo(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Text(
        text = text,
        modifier = modifier.then(Modifier.clickable(true, onClick = onClick)),
        style = moreInfoTextStyle
    )
}

@Composable
fun BorderlessCard(borderlessCardDto: BorderlessCardDto) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(color = BgPrimary),
    ) {
        CardStatusComponent(
            title = borderlessCardDto.status.title,
            text = borderlessCardDto.status.text,
            statusColor = borderlessCardDto.status.statusColor,
            statusDescription = borderlessCardDto.status.statusDescription
        )
        borderlessCardDto.items.mapIndexed { index, item ->
            CardComponent(
                title = item.title, text = item.text, modifier = Modifier.padding(top = 24.dp)
            )
        }
        MoreInfo(
            text = borderlessCardDto.moreInfo.text,
            onClick = borderlessCardDto.moreInfo.onClick,
            modifier = Modifier.padding(top = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BorderlessCardPreview() {
    val borderlessCardDto = BorderlessCardDto(
        items = listOf(
            CardItemDto(
                title = "Автомобиль", text = "Chery Arrizo 8"
            ),
            CardItemDto(
                title = "Даты брони", text = "01.04.2025 - 08.04.2025"
            ),
        ),
        status = StatusItemDto(
            title = "Статус",
            text = "Создана",
            statusColor = IndicatorAttention,
            statusDescription = "Описание статуса"
        ),
        moreInfo = MoreInfoDto(
            text = "Подробнее", onClick = {}),
    )
    BorderlessCard(borderlessCardDto)
}



