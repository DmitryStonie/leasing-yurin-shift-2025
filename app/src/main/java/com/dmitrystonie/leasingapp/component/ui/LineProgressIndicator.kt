package com.dmitrystonie.leasingapp.component.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.ui.theme.IndicatorLight
import com.dmitrystonie.leasingapp.ui.theme.IndicatorPositive


@Composable
fun LineProgressIndicator(modifier: Modifier = Modifier, progress: Float, title: String){
    Column(modifier = modifier) {
        SmallestTitle(
            modifier = Modifier.padding(bottom = 8.dp),
            text = title
        )
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth(),
            trackColor = IndicatorLight,
            color = IndicatorPositive
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LineProgressIndicatorPreview(){
    Column {
        SmallestTitle(
            modifier = Modifier.padding(bottom = 8.dp),
            text = "Шаг 1 из 3"
        )
        LinearProgressIndicator(
            progress = { 0.33f },
            modifier = Modifier.fillMaxWidth(),
            trackColor = IndicatorLight,
            color = IndicatorPositive
        )
    }
}