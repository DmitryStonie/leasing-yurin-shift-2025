package com.dmitrystonie.leasingapp.component.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.ui.theme.BorderExtraLight
import com.dmitrystonie.leasingapp.ui.theme.TextPrimary
import com.dmitrystonie.leasingapp.ui.theme.TextTertiary

@Composable
fun Specs(modifier: Modifier = Modifier, title: String, specs: List<Pair<String, String>>) {
    Column(modifier = modifier) {
        Subtitle(
            modifier = Modifier.padding(bottom = 16.dp), text = title
        )
        SpecList(
            specs = specs
        )
    }
}


@Composable
fun SpecList(modifier: Modifier = Modifier, specs: List<Pair<String, String>>) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(specs) { index, spec ->
            SpecElement(
                name = spec.first,
                value = spec.second,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            if (index < specs.lastIndex) HorizontalDivider(
                color = BorderExtraLight, modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

@Composable
fun SpecElement(modifier: Modifier = Modifier, name: String, value: String) {
    Row(modifier = modifier.fillMaxWidth()) {
        Paragraph(
            modifier = Modifier.weight(1f).padding(end = 8.dp),
            color = TextTertiary, text = name
        )
        Paragraph(
            modifier = Modifier.weight(1f).padding(start = 8.dp),
            color = TextPrimary, text = value
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SpecsPreview() {
    val specs = listOf(
        Pair("Коробка передач", "Автоматическая"),
        Pair("Сторона руля", "Слева"),
        Pair("Тип кузова", "Кроссовер"),
        Pair("Цвет", "Чёрный"),
    )
    Specs(
        title = "Характеристики",
        specs = specs,
    )
}