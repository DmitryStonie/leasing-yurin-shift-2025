package com.dmitrystonie.leasingapp.auth.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmitrystonie.leasingapp.R
import com.dmitrystonie.leasingapp.component.ui.CarsTopAppBarWithLeftIcon
import com.dmitrystonie.leasingapp.component.ui.ColouredButton
import com.dmitrystonie.leasingapp.component.ui.InputTextField
import com.dmitrystonie.leasingapp.component.ui.Paragraph
import com.dmitrystonie.leasingapp.ui.theme.BgBrand
import com.dmitrystonie.leasingapp.ui.theme.BgDisable
import com.dmitrystonie.leasingapp.ui.theme.BgPrimary
import com.dmitrystonie.leasingapp.ui.theme.IndicatorLight
import com.dmitrystonie.leasingapp.ui.theme.TextBrandDisabled
import com.dmitrystonie.leasingapp.ui.theme.TextInvert
import com.dmitrystonie.leasingapp.ui.theme.TextPrimary

@Composable
fun AuthPhoneScreen() {
    val modifier = Modifier
        .padding(start = 16.dp, end = 16.dp, top = 24.dp)
        .fillMaxWidth()
    Column(
        modifier = Modifier
            .background(BgPrimary)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar()

        AuthMessage(modifier = modifier)

        PhoneField(modifier = modifier)

        AuthButton(modifier = modifier)

    }
}

@Composable
private fun PhoneField(modifier: Modifier = Modifier) {
    InputTextField(
        modifier = modifier,
        text = "",
        onValueChange = {},
        placeholderText = stringResource(R.string.auth_user_phone_field_placeholder),
    )
}

@Composable
private fun AuthMessage(modifier: Modifier = Modifier) {
    Paragraph(
        modifier = modifier, color = TextPrimary, text = stringResource(R.string.auth_user_message)
    )
}

@Composable
private fun TopBar() {
    CarsTopAppBarWithLeftIcon(
        text = stringResource(R.string.auth_screen_topbar_text),
        icon = painterResource(R.drawable.cross),
        iconColor = IndicatorLight,
        description = stringResource(R.string.auth_screen_exit_icon_description),
        onClick = {})
}

@Composable
private fun AuthButton(modifier: Modifier = Modifier) {
    ColouredButton(
        modifier = modifier, onClick = {}, buttonColors = ButtonDefaults.buttonColors(
            contentColor = TextInvert,
            containerColor = BgBrand,
            disabledContainerColor = BgDisable,
            disabledContentColor = TextBrandDisabled,
        ), text = stringResource(R.string.auth_screen_button_text)
    )
}


@Preview(showBackground = true)
@Composable
private fun AuthPhoneScreenPreview() {
    AuthPhoneScreen()
}