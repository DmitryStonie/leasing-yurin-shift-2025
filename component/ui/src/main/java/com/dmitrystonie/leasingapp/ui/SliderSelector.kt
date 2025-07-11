package com.dmitrystonie.leasingapp.component.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.component.theme.BgPrimary
import com.dmitrystonie.leasingapp.component.theme.TextPrimary

@Composable
fun SliderSelectorWithLabels(
    modifier: Modifier = Modifier, topLabel: String, fromValue: String, toValue: String
) {
    Column(modifier = modifier) {
        SmallTitleThin(
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp, start = 12.dp, end = 12.dp), text = topLabel
        )
        SliderSelector(Modifier.fillMaxWidth())
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            SmallestTitle(text = fromValue)
            SmallestTitle(text = toValue)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SliderSelector(modifier: Modifier) {
    var sliderPosition by remember { mutableStateOf(0f) }
    Slider(
        modifier = modifier,
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        thumb = { state ->
            Icon(
                painter = painterResource(R.drawable.arrow_2),
                contentDescription = stringResource(R.string.filters_money_slider_description),
                modifier = Modifier
                    .size(24.dp)
                    .clip(
                        CircleShape
                    )
                    .background(TextPrimary),
                tint = BgPrimary
            )
        },
        track = { sliderState ->
            SliderDefaults.Track(
                sliderState = sliderState,
                thumbTrackGapSize = 0.dp,
                modifier = Modifier.height(4.dp),
                colors = SliderColors(
                    thumbColor = BgPrimary,
                    activeTrackColor = TextPrimary,
                    activeTickColor = TextPrimary,
                    inactiveTrackColor = TextPrimary,
                    inactiveTickColor = TextPrimary,
                    disabledThumbColor = TextPrimary,
                    disabledActiveTrackColor = TextPrimary,
                    disabledActiveTickColor = TextPrimary,
                    disabledInactiveTrackColor = TextPrimary,
                    disabledInactiveTickColor = TextPrimary
                )
            )
        })

}

@Preview
@Composable
fun SliderSelectorPreview() {
    SliderSelectorWithLabels(
        topLabel = "Стоимость",
        fromValue = "3 000 Р",
        toValue = "до 10 000 Р",
    )
}