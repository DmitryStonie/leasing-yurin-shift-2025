package com.dmitrystonie.leasingapp.carlooking.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dmitrystonie.leasingapp.ui.theme.TextPrimary
import com.dmitrystonie.leasingapp.ui.theme.appFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarsTopAppBar(text: String, modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            CarsTopAppBarTitle(text)
        },
        modifier = modifier.padding(horizontal = 16.dp, vertical = 12.dp)
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
        },
        modifier = modifier.padding(horizontal = 16.dp, vertical = 12.dp)
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
        },
        actions = {
            IconButton({ }) {
                Icon(
                    painter = icon,
                    contentDescription = description,
                    tint = iconColor
                )
            }
        },
        modifier = modifier.padding(horizontal = 16.dp, vertical = 12.dp)
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
) {
    TopAppBar(
        title = {
            CarsTopAppBarTitle(text)
        },
        navigationIcon = {
            IconButton({ }) {
                Icon(
                    painter = icon,
                    contentDescription = description,
                    tint = iconColor
                )
            }
        },
        modifier = modifier.padding(horizontal = 16.dp, vertical = 12.dp)
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
        lineHeight = 32.sp
    )
}