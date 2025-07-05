package com.dmitrystonie.leasingapp.component.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonGroupDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButton
import androidx.compose.material3.ToggleButtonColors
import androidx.compose.material3.ToggleButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.ui.theme.BgPrimary
import com.dmitrystonie.leasingapp.ui.theme.BgSecondary
import com.dmitrystonie.leasingapp.ui.theme.TextPrimary
import com.dmitrystonie.leasingapp.ui.theme.TextTertiary

@Composable
fun MultipleButtonWithLabel(options: List<String>, label: String){
    Column {
        SmallTitleThin(modifier = Modifier.padding(bottom = 4.dp), text = label)
        MultipleButton(options)
    }
}



@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MultipleButton(options: List<String>) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    Row(
        Modifier.clip(RoundedCornerShape(14.dp)).background(color = BgSecondary).padding(horizontal = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(ButtonGroupDefaults.ConnectedSpaceBetween),
    ) {
        val modifiers = listOf(Modifier.weight(1f), Modifier.weight(1f), Modifier.weight(1f))

        options.forEachIndexed { index, label ->
            ToggleButton(
                checked = selectedIndex == index,
                onCheckedChange = { selectedIndex = index },
                modifier = modifiers[index].semantics { role = Role.RadioButton },
                shapes = ButtonGroupDefaults.connectedMiddleButtonShapes(
                    shape = RoundedCornerShape(14.dp),
                    pressedShape =  RoundedCornerShape(14.dp),
                    checkedShape =  RoundedCornerShape(14.dp),
                ),
                colors = ToggleButtonColors(
                    containerColor = BgSecondary,
                    contentColor = TextTertiary,
                    disabledContainerColor = BgSecondary,
                    disabledContentColor = TextTertiary,
                    checkedContainerColor = BgPrimary,
                    checkedContentColor = TextPrimary
                )
            ) {
                Spacer(Modifier.size(ToggleButtonDefaults.IconSpacing))
                Text(label, style = textItemSecondaryStyleWithoutColor)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TripleButtonPreview() {
    MultipleButtonWithLabel(listOf("Любой", "Левый", "Правый"), "Руль")
}
