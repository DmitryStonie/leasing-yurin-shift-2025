package com.dmitrystonie.leasingapp.component.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.component.theme.BgBrand
import com.dmitrystonie.leasingapp.component.theme.BgPrimary
import com.dmitrystonie.leasingapp.component.theme.BorderLight

@Composable
fun UserCheckbox(modifier: Modifier = Modifier, text: String, onClick: (Boolean) -> Unit) {
    Row(
        modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = false, enabled = true,
            colors = CheckboxColors(
                checkedCheckmarkColor = BgBrand,
                uncheckedCheckmarkColor = BgPrimary,
                checkedBoxColor = BgBrand,
                uncheckedBoxColor = BgPrimary,
                disabledCheckedBoxColor = BgBrand,
                disabledUncheckedBoxColor = BorderLight,
                disabledIndeterminateBoxColor = BorderLight,
                checkedBorderColor = BorderLight,
                uncheckedBorderColor = BorderLight,
                disabledBorderColor = BorderLight,
                disabledUncheckedBorderColor = BorderLight,
                disabledIndeterminateBorderColor = BorderLight
            ),
            onCheckedChange = onClick,
        )
        Subtitle(
            modifier = Modifier.padding(start = 16.dp),
            text = text
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserCheckboxPreview() {
    UserCheckbox(
        text = "Принимаю условия соглашения", onClick = {})
}