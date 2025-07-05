package com.dmitrystonie.leasingapp.component.ui

import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.dmitrystonie.leasingapp.R
import com.dmitrystonie.leasingapp.ui.theme.BgBrand
import com.dmitrystonie.leasingapp.ui.theme.BgPrimary
import com.dmitrystonie.leasingapp.ui.theme.appFontFamily
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.ui.theme.BgDisable
import com.dmitrystonie.leasingapp.ui.theme.IndicatorMedium
import com.dmitrystonie.leasingapp.ui.theme.TextTertiary


private val AppBarTextStyle = TextStyle(
    fontSize = 10.sp,
    fontWeight = FontWeight.W400,
    fontFamily = appFontFamily,
    letterSpacing = 0.sp,
    lineHeight = 12.sp,
)

private val NavItemColors = NavigationBarItemColors(
    selectedIconColor = BgBrand,
    selectedTextColor = BgBrand,
    selectedIndicatorColor = BgPrimary,
    unselectedIconColor = IndicatorMedium,
    unselectedTextColor = TextTertiary,
    disabledIconColor = BgDisable,
    disabledTextColor = BgDisable,
)

@Composable
fun CarsBottomAppBar(modifier: Modifier = Modifier) {
    BottomAppBar(
        modifier = modifier.height(58.dp),
        containerColor = BgPrimary,
        contentColor = BgBrand,
    ) {
        NavigationBarItem(selected = true, onClick = {}, icon = {
            Icon(
                painter = painterResource(R.drawable.car),
                contentDescription = stringResource(R.string.car_icon_description)
            )
        }, colors = NavItemColors, label = {
            Text(
                text = stringResource(R.string.bottom_app_bar_cars_title),
                style = AppBarTextStyle,
            )
        })
        NavigationBarItem(selected = false, onClick = {}, icon = {
            Icon(
                painter = painterResource(R.drawable.time),
                contentDescription = stringResource(R.string.time_icon_description)
            )
        }, colors = NavItemColors, label = {
            Text(
                text = stringResource(R.string.bottom_app_bar_cars_title),
                style = AppBarTextStyle,
            )
        })
        NavigationBarItem(selected = false, onClick = {}, icon = {
            Icon(
                painter = painterResource(R.drawable.user),
                contentDescription = stringResource(R.string.user_icon_description)
            )
        }, colors = NavItemColors, label = {
            Text(
                text = stringResource(R.string.bottom_app_bar_cars_title),
                style = AppBarTextStyle,
            )
        })

    }
}

@Preview(showBackground = true)
@Composable
private fun CarsBottomAppBarPreview(modifier: Modifier = Modifier) {
    CarsBottomAppBar(modifier)
}