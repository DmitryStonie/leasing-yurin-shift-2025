package com.dmitrystonie.leasingapp.component.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dmitrystonie.leasingapp.component.theme.BgDisable
import com.dmitrystonie.leasingapp.component.theme.BgPrimary
import com.dmitrystonie.leasingapp.component.theme.BorderLight
import com.dmitrystonie.leasingapp.component.theme.LeasingAppTheme
import com.dmitrystonie.leasingapp.component.theme.TextBrandDisabled
import com.dmitrystonie.leasingapp.component.theme.TextSecondary
import com.dmitrystonie.leasingapp.component.theme.appFontFamily

@Composable
fun ColouredButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonColors: ButtonColors,
    text: String? = null,
    border: BorderStroke? = null,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = buttonColors,
        border = border,
        contentPadding = PaddingValues(0.dp)
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
    border: BorderStroke? = null,
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(56.dp),
        shape = RoundedCornerShape(16.dp),
        colors = buttonColors,
        border = border,
    ) {
        Icon(
            painter = iconPainter,
            contentDescription = iconContentDescription,
            modifier = Modifier.padding(end = 8.dp)
        )
        ButtonText(text = text)
    }
}

@Composable
fun ButtonText(modifier: Modifier = Modifier, text: String? = null) {
    Text(
        text = text ?: "",
        modifier = modifier.height(56.dp).wrapContentHeight(align = Alignment.CenterVertically),
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
private fun ColouredButtonWithIconPreview(
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
            border = BorderStroke(1.dp, BorderLight),
        )
    }
}