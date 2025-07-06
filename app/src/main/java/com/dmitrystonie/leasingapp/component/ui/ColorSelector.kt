package com.dmitrystonie.leasingapp.component.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.R
import com.dmitrystonie.leasingapp.ui.theme.BorderBitLight
import com.dmitrystonie.leasingapp.ui.theme.ColorBlack
import com.dmitrystonie.leasingapp.ui.theme.ColorBlue
import com.dmitrystonie.leasingapp.ui.theme.ColorBrown
import com.dmitrystonie.leasingapp.ui.theme.ColorGreen
import com.dmitrystonie.leasingapp.ui.theme.ColorRed
import com.dmitrystonie.leasingapp.ui.theme.ColorWhite
import com.dmitrystonie.leasingapp.ui.theme.ColorYellow

@Composable
fun ColorSelector(modifier: Modifier = Modifier, colors: List<Pair<Painter, String>>) {
    Column(modifier = modifier) {
        SmallTitleThin(
            modifier = Modifier.padding(bottom = 8.dp),
            text = stringResource(R.string.cars_filter_color_selector_headline)
        )
        FlowRow(
            Modifier.fillMaxWidth(),
            maxItemsInEachRow = 7,
            verticalArrangement = Arrangement.spacedBy(
                8.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            colors.forEachIndexed { index, color ->
                ColorSelectorItem(color.first, color.second)
            }
        }
    }
}


@Composable
fun ColorSelectorItem(painter: Painter, colorDescription: String) {
    Icon(
        painter = painter,
        contentDescription = colorDescription,
        modifier = Modifier
            .size(40.dp)
            .border(1.dp, color = BorderBitLight, CircleShape)
            .clip(shape = CircleShape)
            .padding(4.dp)
            .clip(shape = CircleShape),
        tint = Color.Unspecified
    )
}

@Preview
@Composable
fun ColorSelectorItemPreview() {
    ColorSelectorItem(ColorPainter(ColorGreen), "Зеленый")
}

@Preview
@Composable
fun ColorSelectorPreview() {
    val colors = listOf(
        Pair(painterResource(R.drawable.custom_color), "Собственный цвет"),
        Pair(ColorPainter(ColorWhite), "Белый"),
        Pair(ColorPainter(ColorBlack), "Черный"),
        Pair(ColorPainter(ColorBrown), "Коричневый"),
        Pair(ColorPainter(ColorGreen), "Зеленый"),
        Pair(ColorPainter(ColorRed), "Красный"),
        Pair(ColorPainter(ColorYellow), "Желтый"),
        Pair(ColorPainter(ColorBlue), "Синий"),
    )
    ColorSelector(colors = colors)
}