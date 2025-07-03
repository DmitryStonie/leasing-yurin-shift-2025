package com.dmitrystonie.leasingapp.carlooking.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dmitrystonie.leasingapp.R
import com.dmitrystonie.leasingapp.ui.theme.BgDisable
import com.dmitrystonie.leasingapp.ui.theme.BgPrimary
import com.dmitrystonie.leasingapp.ui.theme.BorderLight
import com.dmitrystonie.leasingapp.ui.theme.LeasingAppTheme
import com.dmitrystonie.leasingapp.ui.theme.TextBrandDisabled
import com.dmitrystonie.leasingapp.ui.theme.TextSecondary
import com.dmitrystonie.leasingapp.ui.theme.appFontFamily

@Composable
fun ColouredButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonColors: ButtonColors,
    text: String = ""
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = buttonColors,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 2.dp,
            pressedElevation = 8.dp,
            disabledElevation = 0.dp,
            hoveredElevation = 4.dp,
            focusedElevation = 4.dp
        ),
    ) {
        ButtonText(text = text)
    }
}

@Composable
fun ColouredButtonWithIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonColors: ButtonColors,
    text: String = "",
    iconPainter: Painter,
    iconContentDescription: String,
    border: BorderStroke
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = buttonColors,
        border = border
    ) {
        Icon(
            painter = iconPainter,
            contentDescription = iconContentDescription,
        )
        ButtonText(text = text)
    }
}

@Composable
fun ButtonText(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        modifier = modifier.padding(16.dp),
        fontSize = 16.sp,
        fontWeight = FontWeight.W600,
        fontFamily = appFontFamily,
        letterSpacing = 0.sp,
        textAlign = TextAlign.Center,
        lineHeight = 24.sp,
        maxLines = 1,
    )
}

@Preview(showBackground = true)
@Composable
fun ColouredButtonWithIconPreview(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonColors: ButtonColors,
    text: String = "",
    iconPainter: Painter,
    iconContentDescription: String,
    border: BorderStroke
) {
    LeasingAppTheme {
        ColouredButtonWithIcon(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            buttonColors = ButtonDefaults.buttonColors(
                contentColor = TextSecondary,
                containerColor = BgPrimary,
                disabledContainerColor = BgDisable,
                disabledContentColor = TextBrandDisabled,
            ),
            text = "Войти",
            painterResource(R.drawable.sliders),
            iconContentDescription = "Открыть даты",
            border = BorderStroke(1.dp, BorderLight)
        )
    }
}