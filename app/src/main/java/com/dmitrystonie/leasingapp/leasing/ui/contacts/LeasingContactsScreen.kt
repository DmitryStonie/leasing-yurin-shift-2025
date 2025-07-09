package com.dmitrystonie.leasingapp.leasing.ui.contacts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmitrystonie.leasingapp.R
import com.dmitrystonie.leasingapp.component.ui.CarsTopAppBarWithLeftIcon
import com.dmitrystonie.leasingapp.component.ui.ColouredButton
import com.dmitrystonie.leasingapp.component.ui.InputTextFieldWithTitle
import com.dmitrystonie.leasingapp.component.ui.LineProgressIndicator
import com.dmitrystonie.leasingapp.component.ui.UserCheckbox
import com.dmitrystonie.leasingapp.leasing.presentation.BookingViewModel
import com.dmitrystonie.leasingapp.ui.theme.BgBrand
import com.dmitrystonie.leasingapp.ui.theme.BgPrimary
import com.dmitrystonie.leasingapp.ui.theme.BorderLight
import com.dmitrystonie.leasingapp.ui.theme.TextInvert

@Composable
fun LeasingContactsScreen(
    carId: String, onBackClick: () -> Unit, onNextClick: () -> Unit
) {
    val viewModel: BookingViewModel =
        hiltViewModel<BookingViewModel, BookingViewModel.BookingViewModelFactory> { factory ->
            factory.create(carId)
        }

    val modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    Column {
        Column(
            modifier = Modifier
                .background(BgPrimary)
                .verticalScroll(rememberScrollState())
                .weight(weight = 1f, fill = false),
            verticalArrangement = Arrangement.SpaceBetween,

            ) {
            TopBar(onBackClick)

            Indicator(
                modifier = modifier.padding(top = 16.dp)
            )

            LastNameField(
                modifier = modifier.padding(top = 16.dp)
            )

            FirstNameField(
                modifier = modifier.padding(top = 16.dp)
            )

            MiddleNameField(
                modifier = modifier.padding(top = 16.dp)
            )

            BirthdateField(
                modifier = modifier.padding(top = 16.dp)
            )

            PhoneField(
                modifier = modifier.padding(top = 16.dp)
            )

            EmailField(
                modifier = modifier.padding(top = 16.dp)
            )

            CommentField(
                modifier = modifier.padding(top = 16.dp)
            )

            AgreementCheckbox(
                onClick = {}, modifier = modifier.padding(top = 16.dp)
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
            NextButton(
                onClick = onNextClick
            )

        }
    }

}

@Composable
fun TopBar(onClick: () -> Unit) {
    CarsTopAppBarWithLeftIcon(
        text = stringResource(R.string.leasing_screen_step_2_title),
        icon = painterResource(R.drawable.ic_left),
        iconColor = BorderLight,
        description = stringResource(R.string.leasing_back_description),
        onClick = onClick
    )
}

@Composable
fun NextButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    ColouredButton(
        modifier = modifier,
        onClick = onClick,
        buttonColors = ButtonColors(
            containerColor = BgBrand,
            contentColor = TextInvert,
            disabledContainerColor = BgBrand,
            disabledContentColor = TextInvert
        ),
        text = stringResource(R.string.leasing_continue_button_text),
    )
}

@Composable
fun AgreementCheckbox(modifier: Modifier = Modifier, onClick: (Boolean) -> Unit) {
    UserCheckbox(
        modifier = modifier,
        text = stringResource(R.string.leasing_agreement_accept_text),
        onClick = onClick,
    )
}

@Composable
fun CommentField(modifier: Modifier = Modifier) {
    InputTextFieldWithTitle(
        modifier = modifier,
        titleText = stringResource(R.string.leasing_comment_headline),
        fieldText = "",
        placeholderText = stringResource(R.string.leasing_comment_placeholder),
        onValueChange = {},
        minLines = 4,
    )
}

@Composable
fun EmailField(modifier: Modifier = Modifier) {
    InputTextFieldWithTitle(
        modifier = modifier,
        titleText = stringResource(R.string.leasing_email_headline),
        fieldText = "",
        placeholderText = stringResource(R.string.leasing_email_placeholder),
        onValueChange = {},
    )
}

@Composable
fun PhoneField(modifier: Modifier = Modifier) {
    InputTextFieldWithTitle(
        modifier = modifier,
        titleText = stringResource(R.string.leasing_phone_number_headline),
        fieldText = "",
        placeholderText = stringResource(R.string.leasing_phone_number_placeholder),
        onValueChange = {},
    )
}

@Composable
fun BirthdateField(modifier: Modifier = Modifier) {
    InputTextFieldWithTitle(
        modifier = modifier,
        titleText = stringResource(R.string.leasing_birthdate_headline),
        fieldText = "",
        placeholderText = stringResource(R.string.leasing_birthdate_placeholder),
        onValueChange = {},
    )
}

@Composable
fun MiddleNameField(modifier: Modifier = Modifier) {
    InputTextFieldWithTitle(
        modifier = modifier,
        titleText = stringResource(R.string.leasing_middlename_headline),
        fieldText = "",
        placeholderText = stringResource(R.string.leasing_middlename_placeholder),
        onValueChange = {},
    )
}

@Composable
fun FirstNameField(modifier: Modifier = Modifier) {
    InputTextFieldWithTitle(
        modifier = modifier,
        titleText = stringResource(R.string.leasing_firstname_headline),
        fieldText = "",
        placeholderText = stringResource(R.string.leasing_lastname_placeholder),
        onValueChange = {},
    )
}

@Composable
fun LastNameField(modifier: Modifier = Modifier) {
    InputTextFieldWithTitle(
        modifier = modifier,
        titleText = stringResource(R.string.leasing_lastname_headline),
        fieldText = "",
        placeholderText = stringResource(R.string.leasing_lastname_placeholder),
        onValueChange = {},
    )
}

@Composable
fun Indicator(modifier: Modifier = Modifier) {
    LineProgressIndicator(
        modifier = modifier,
        progress = 0.67f,
        title = stringResource(R.string.leasing_step_text, 2, 3)
    )
}

@Preview(showBackground = true)
@Composable
fun LeasingContactsScreenPreview() {
    val modifier = Modifier.padding(start = 16.dp, end = 16.dp)

    Column(
        modifier = Modifier.background(BgPrimary),
        verticalArrangement = Arrangement.SpaceBetween,

        ) {
        TopBar({})

        Indicator(
            modifier = modifier.padding(top = 16.dp)
        )

        LastNameField(
            modifier = modifier.padding(top = 16.dp)
        )

        FirstNameField(
            modifier = modifier.padding(top = 16.dp)
        )

        MiddleNameField(
            modifier = modifier.padding(top = 16.dp)
        )

        BirthdateField(
            modifier = modifier.padding(top = 16.dp)
        )

        PhoneField(
            modifier = modifier.padding(top = 16.dp)
        )

        EmailField(
            modifier = modifier.padding(top = 16.dp)
        )

        CommentField(
            modifier = modifier.padding(top = 16.dp)
        )

        AgreementCheckbox(
            onClick = {}, modifier = modifier.padding(top = 16.dp)
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        NextButton(
            onClick = { })

    }
}