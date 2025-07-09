package com.dmitrystonie.leasingapp.component.ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.ui.NavigationOption
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
fun CarsBottomAppBar(
    navigationOptions: List<NavigationOption>,
    selectedNavigationOption: NavigationOption,
    onItemClicked: (NavigationOption) -> Unit,
    modifier: Modifier = Modifier
) {
    BottomAppBar(
        modifier = modifier.height(58.dp),
        containerColor = BgPrimary,
        contentColor = BgBrand,
    ) {
        for (option in navigationOptions) {
            NavigationBarItem(
                selected = selectedNavigationOption == option, onClick = { onItemClicked(option) },
                icon = {
                    Icon(
                        painter = getIconPainter(option),
                        contentDescription = getIconDescription(option),
                    )
                },
                colors = NavItemColors,
                label = {
                    Text(
                        modifier = modifier.padding(top = 0.dp),
                        text = getIconText(option),
                        style = AppBarTextStyle,
                    )
                },
            )
        }

    }
}

@Composable
private fun getIconPainter(option: NavigationOption): Painter = painterResource(
    when (option) {
        NavigationOption.CARS -> R.drawable.car
        NavigationOption.ORDERS -> R.drawable.time
        NavigationOption.ACCOUNT -> R.drawable.user
    }
)

@Composable
private fun getIconDescription(option: NavigationOption): String = stringResource(
    when (option) {
        NavigationOption.CARS -> R.string.car_icon_description
        NavigationOption.ORDERS -> R.string.time_icon_description
        NavigationOption.ACCOUNT -> R.string.user_icon_description
    }
)

@Composable
private fun getIconText(option: NavigationOption): String = stringResource(
    when (option) {
        NavigationOption.CARS -> R.string.bottom_app_bar_cars_title
        NavigationOption.ORDERS -> R.string.bottom_app_bar_orders_title
        NavigationOption.ACCOUNT -> R.string.bottom_app_bar_profile_title
    }
)

@Preview(showBackground = true)
@Composable
private fun CarsBottomAppBarPreview(modifier: Modifier = Modifier) {
    CarsBottomAppBar(
        navigationOptions = NavigationOption.entries,
        selectedNavigationOption = NavigationOption.CARS,
        onItemClicked = {},
        modifier = modifier
    )
}