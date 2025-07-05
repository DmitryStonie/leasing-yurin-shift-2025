package com.dmitrystonie.leasingapp.component.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dmitrystonie.leasingapp.ui.theme.BgPrimary
import com.dmitrystonie.leasingapp.ui.theme.IndicatorLight
import com.dmitrystonie.leasingapp.ui.theme.TextPrimary
import com.dmitrystonie.leasingapp.ui.theme.appFontFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarsTopAppBar(text: String, modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            CarsTopAppBarTitle(text)
        },
        colors = TopAppBarColors(
            containerColor = BgPrimary,
            scrolledContainerColor = BgPrimary,
            navigationIconContentColor = IndicatorLight,
            titleContentColor = IndicatorLight,
            actionIconContentColor = IndicatorLight,
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarsTopAppBarWithoutIcons(
    modifier: Modifier = Modifier,
    text: String = "",
) {
    TopAppBar(
        title = {
            CarsTopAppBarTitle(text)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarsTopAppBarWithRightIcon(
    modifier: Modifier = Modifier,
    text: String = "",
    icon: Painter,
    iconColor: Color,
    description: String,

    ) {
    TopAppBar(
        title = {
            CarsTopAppBarTitle(text)
        }, actions = {
            IconButton({ }) {
                Icon(
                    painter = icon, contentDescription = description, tint = iconColor
                )
            }
        },
        modifier = modifier,
        colors = TopAppBarColors(
            containerColor = BgPrimary,
            scrolledContainerColor = BgPrimary,
            navigationIconContentColor = IndicatorLight,
            titleContentColor = TextPrimary,
            actionIconContentColor = IndicatorLight,
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarsTopAppBarWithLeftIcon(
    modifier: Modifier = Modifier,
    text: String = "",
    icon: Painter,
    iconColor: Color,
    description: String,
    onClick: () -> Unit
) {
    TopAppBar(
        title = {
            CarsTopAppBarTitle(text)
        }, navigationIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    painter = icon, contentDescription = description, tint = iconColor
                )
            }
        },
        modifier = modifier,
        colors = TopAppBarColors(
            containerColor = BgPrimary,
            scrolledContainerColor = BgPrimary,
            navigationIconContentColor = IndicatorLight,
            titleContentColor = TextPrimary,
            actionIconContentColor = IndicatorLight,
        )
    )
}

@Composable
fun CarsTopAppBarTitle(text: String) {
    Text(
        text,
        fontSize = 24.sp,
        color = TextPrimary,
        fontFamily = appFontFamily,
        fontWeight = FontWeight.W700,
        lineHeight = 32.sp,
    )
}