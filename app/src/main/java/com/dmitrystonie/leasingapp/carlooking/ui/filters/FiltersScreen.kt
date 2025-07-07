package com.dmitrystonie.leasingapp.carlooking.ui.filters

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.R
import com.dmitrystonie.leasingapp.component.ui.CarsTopAppBarWithRightIcon
import com.dmitrystonie.leasingapp.component.ui.ColorSelector
import com.dmitrystonie.leasingapp.component.ui.ColouredButton
import com.dmitrystonie.leasingapp.component.ui.InputTextFieldWithTitle
import com.dmitrystonie.leasingapp.component.ui.MultipleButtonWithLabel
import com.dmitrystonie.leasingapp.component.ui.SliderSelectorWithLabels
import com.dmitrystonie.leasingapp.ui.theme.BgBrand
import com.dmitrystonie.leasingapp.ui.theme.BgPrimary
import com.dmitrystonie.leasingapp.ui.theme.BorderLight
import com.dmitrystonie.leasingapp.ui.theme.ColorBlack
import com.dmitrystonie.leasingapp.ui.theme.ColorBlue
import com.dmitrystonie.leasingapp.ui.theme.ColorBrown
import com.dmitrystonie.leasingapp.ui.theme.ColorGreen
import com.dmitrystonie.leasingapp.ui.theme.ColorRed
import com.dmitrystonie.leasingapp.ui.theme.ColorWhite
import com.dmitrystonie.leasingapp.ui.theme.ColorYellow
import com.dmitrystonie.leasingapp.ui.theme.TextInvert
import com.dmitrystonie.leasingapp.ui.theme.TextPrimary
import com.dmitrystonie.leasingapp.ui.theme.TextSecondary
import com.dmitrystonie.leasingapp.ui.theme.TextTertiary

@Composable
fun FiltersScreen() {
    val modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    Column(modifier = Modifier.verticalScroll(rememberScrollState()).background(BgPrimary))
         {
        TopBar(modifier = Modifier.padding(bottom = 24.dp))

        BrandField(modifier = modifier.padding(bottom = 24.dp))

        BodyTypeField(modifier = modifier.padding(bottom = 24.dp))

        SteeringSelector(modifier = modifier.padding(bottom = 24.dp))

        TransmissionSelector(modifier = modifier.padding(bottom = 24.dp))

        PriceSelector(
            modifier = modifier.padding(bottom = 24.dp), from = 3000, to = 10000
        )

        ColorSelector(modifier = modifier.padding(bottom = 40.dp))

        ResetButton(modifier = modifier.padding(bottom = 8.dp).fillMaxWidth())

        FindButton(modifier = modifier.padding(bottom = 16.dp).fillMaxWidth())

    }

}

@Composable
fun FindButton(modifier: Modifier = Modifier) {
    ColouredButton(
        modifier = modifier,
        onClick = {},
        buttonColors = ButtonColors(
            containerColor = BgBrand,
            contentColor = TextInvert,
            disabledContainerColor = BgBrand,
            disabledContentColor = TextInvert
        ),
        text = stringResource(R.string.cars_filter_find_button_title),
    )
}

@Composable
fun ResetButton(modifier: Modifier = Modifier) {
    ColouredButton(
        modifier = modifier,
        onClick = {},
        buttonColors = ButtonColors(
            containerColor = BgPrimary,
            contentColor = TextSecondary,
            disabledContainerColor = BgPrimary,
            disabledContentColor = TextSecondary
        ),
        text = stringResource(R.string.cars_filter_reset_button_title),
        border = BorderStroke(1.dp, BorderLight)
    )
}

@Composable
fun ColorSelector(modifier: Modifier = Modifier) {
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
    ColorSelector(modifier = modifier, colors)
}

@Composable
fun PriceSelector(modifier: Modifier = Modifier, from: Int, to: Int) {
    SliderSelectorWithLabels(
        modifier = modifier,
        topLabel = stringResource(R.string.cars_filter_price_slider_headline),
        fromValue = stringResource(R.string.cars_filter_price_slider_from, from),
        toValue = stringResource(R.string.cars_filter_price_slider_to, to)
    )
}

@Composable
fun TransmissionSelector(modifier: Modifier = Modifier) {
    val options = listOf(
        stringResource(R.string.cars_filter_transmission_any_title),
        stringResource(R.string.cars_filter_transmission_automatic_title),
        stringResource(R.string.cars_filter_transmission_mechanic_title)
    )
    MultipleButtonWithLabel(
        modifier = modifier,
        options = options,
        label = stringResource(R.string.cars_filter_transmission_selector_headline)
    )
}

@Composable
fun SteeringSelector(modifier: Modifier = Modifier) {
    val options = listOf(
        stringResource(R.string.cars_filter_steering_any_title),
        stringResource(R.string.cars_filter_steering_left_title),
        stringResource(R.string.cars_filter_steering_right_title)
    )
    MultipleButtonWithLabel(
        modifier = modifier,
        options = options,
        label = stringResource(R.string.cars_filter_steering_selector_headline)
    )
}

@Composable
fun BodyTypeField(modifier: Modifier = Modifier) {
    InputTextFieldWithTitle(
        modifier = modifier,
        titleText = stringResource(R.string.cars_filter_body_type_field_headline),
        fieldText = "",
        placeholderText = stringResource(R.string.cars_filter_body_type_field_hint),
        onValueChange = {},
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.chevron_down),
                contentDescription = stringResource(R.string.filters_select_body_type_description),
                tint = TextTertiary
            )
        })
}

@Composable
fun BrandField(modifier: Modifier = Modifier) {
    InputTextFieldWithTitle(
        modifier = modifier,
        titleText = stringResource(R.string.cars_filter_brand_field_headline),
        fieldText = "",
        placeholderText = stringResource(R.string.cars_filter_brand_field_hint),
        onValueChange = {},
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.chevron_down),
                contentDescription = stringResource(R.string.filters_select_brand_description),
                tint = TextTertiary
            )
        })
}

@Composable
private fun TopBar(modifier: Modifier = Modifier) {
    CarsTopAppBarWithRightIcon(
        modifier = modifier,
        text = stringResource(R.string.cars_top_app_bar_title),
        icon = painterResource(R.drawable.cross),
        iconColor = TextPrimary,
        description = stringResource(R.string.filters_screen_exit_description)
    )
}

@Preview
@Composable
private fun FiltersScreenPreview() {
    FiltersScreen()
}