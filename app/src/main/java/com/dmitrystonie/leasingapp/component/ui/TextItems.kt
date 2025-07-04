package com.dmitrystonie.leasingapp.component.ui

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.dmitrystonie.leasingapp.ui.theme.TextPrimary
import com.dmitrystonie.leasingapp.ui.theme.TextQuartenery
import com.dmitrystonie.leasingapp.ui.theme.TextSecondary
import com.dmitrystonie.leasingapp.ui.theme.appFontFamily

val textItemStyle = TextStyle(
    color = TextPrimary,
    fontSize = 16.sp,
    fontWeight = FontWeight.W400,
    fontFamily = appFontFamily,
    letterSpacing = 0.sp,
    lineHeight = 24.sp,
)

val textItemSecondaryStyle = TextStyle(
    color = TextQuartenery,
    fontSize = 14.sp,
    fontWeight = FontWeight.W400,
    fontFamily = appFontFamily,
    letterSpacing = 0.sp,
    lineHeight = 20.sp,
)

val textItemWithActionStyle = TextStyle(
    color = TextSecondary,
    fontSize = 16.sp,
    fontWeight = FontWeight.W600,
    fontFamily = appFontFamily,
    letterSpacing = 0.sp,
    lineHeight = 24.sp,
    textAlign = TextAlign.Center
)

private val smallTitleTextStyle = TextStyle(
    color = TextPrimary,
    fontSize = 14.sp,
    fontWeight = FontWeight.W500,
    fontFamily = appFontFamily,
    letterSpacing = 0.sp,
    lineHeight = 20.sp,
)

private val primaryTitleThinTextStyle = TextStyle(
    color = TextPrimary,
    fontSize = 14.sp,
    fontWeight = FontWeight.W400,
    fontFamily = appFontFamily,
    letterSpacing = 0.sp,
    lineHeight = 20.sp,
)

private val titleTextStyle = TextStyle(
    color = TextPrimary,
    fontSize = 24.sp,
    fontWeight = FontWeight.W700,
    fontFamily = appFontFamily,
    letterSpacing = 0.sp,
    lineHeight = 32.sp,
)

@Composable
fun Paragraph(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text, modifier = modifier, style = textItemStyle
    )
}

@Composable
fun ParagraphSecondary(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text, modifier = modifier, style = textItemSecondaryStyle
    )
}

@Composable
fun TextAction(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Text(
        text = text,
        modifier = modifier.clickable(true) { onClick() },
        style = textItemWithActionStyle,

    )
}

@Composable
fun SmallTitle(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = 1,
        style = smallTitleTextStyle
    )
}


@Composable
fun SmallTitleThin(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = 1,
        style = primaryTitleThinTextStyle
    )
}

@Composable
fun BigTitle(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        modifier = modifier,
        maxLines = 2,
        style = titleTextStyle
    )
}



