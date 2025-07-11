package com.dmitrystonie.leasingapp.component.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dmitrystonie.leasingapp.component.theme.BgPrimary
import com.dmitrystonie.leasingapp.component.theme.BorderLight
import com.dmitrystonie.leasingapp.component.theme.IconPrimary
import com.dmitrystonie.leasingapp.component.theme.TextPrimary
import com.dmitrystonie.leasingapp.component.theme.TextTertiary
import com.dmitrystonie.leasingapp.component.theme.appFontFamily


private val fieldTextTextStyle = TextStyle(
    color = TextPrimary,
    fontSize = 16.sp,
    fontWeight = FontWeight.W400,
    fontFamily = appFontFamily,
    letterSpacing = 0.sp,
    lineHeight = 24.sp,
)
private val placeholderTextStyle = TextStyle(
    color = TextTertiary,
    fontSize = 16.sp,
    fontWeight = FontWeight.W400,
    fontFamily = appFontFamily,
    letterSpacing = 0.sp,
    lineHeight = 24.sp,
)

@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    text: String,
    onValueChange: (String) -> Unit,
    placeholderText: String,
    trailingIcon: @Composable (() -> Unit)? = null,
    minLines: Int = 1,
    maxLines: Int = 1,
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = onValueChange,
        maxLines = maxOf(minLines, maxLines),
        minLines = minLines,
        shape = RoundedCornerShape(8.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = TextPrimary,
            unfocusedTextColor = TextPrimary,
            focusedBorderColor = BorderLight,
            unfocusedBorderColor = BorderLight,
            focusedContainerColor = BgPrimary,
            unfocusedContainerColor = BgPrimary,
            cursorColor = TextPrimary,
            focusedPlaceholderColor = TextTertiary,
            unfocusedPlaceholderColor = TextTertiary,
        ),
        placeholder = {
            TextFieldPlaceholder(text = placeholderText)
        },
        textStyle = fieldTextTextStyle,
        trailingIcon = trailingIcon,
    )
}

@Composable
fun TextFieldPlaceholder(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text,
        modifier = modifier,
        color = TextTertiary,
        style = placeholderTextStyle,
        maxLines = 1,
    )
}


@Composable
fun InputTextFieldWithTitle(
    modifier: Modifier = Modifier,
    titleText: String,
    fieldText: String,
    placeholderText: String,
    onValueChange: (String) -> Unit,
    trailingIcon: @Composable (() -> Unit)? = null,
    minLines: Int = 1,
    maxLines: Int = 1,
) {
    Column(modifier = modifier) {
        SmallTitleThin(modifier = Modifier.padding(bottom = 6.dp), text = titleText)
        InputTextField(
            modifier = Modifier.fillMaxWidth(),
            text = fieldText,
            onValueChange = onValueChange,
            placeholderText = placeholderText,
            trailingIcon = trailingIcon,
            minLines = minLines,
            maxLines = maxLines,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun InputTextFieldPreview(
    modifier: Modifier = Modifier,
    text: String = "",
    placeholderText: String = "Место получения",
    onValueChange: (String) -> Unit = {},
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    InputTextField(
        modifier = modifier,
        text = text,
        onValueChange = onValueChange,
        placeholderText = placeholderText,
        trailingIcon = trailingIcon,
        minLines = 3,
    )
}

@Preview(showBackground = true)
@Composable
private fun InputTextFieldWithTitlePreview(
    modifier: Modifier = Modifier,
    fieldText: String = "ул. Покрышкина",
    titleText: String = "Место получения",
    placeholderText: String = "Место получения",
    onValueChange: (String) -> Unit = {},
    trailingIcon: @Composable (() -> Unit) = {
        Icon(
            painter = painterResource(R.drawable.calendar),
            tint = IconPrimary,
            contentDescription = "Desctiprion"
        )
    },
) {
    InputTextFieldWithTitle(
        modifier = modifier,
        titleText = titleText,
        fieldText = fieldText,
        placeholderText = placeholderText,
        onValueChange = onValueChange,
        trailingIcon = trailingIcon,
    )
}