package com.dmitrystonie.leasingapp.leasing.ui.confirmation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmitrystonie.leasingapp.R
import com.dmitrystonie.leasingapp.car.domain.Rent
import com.dmitrystonie.leasingapp.component.ui.CardItemDto
import com.dmitrystonie.leasingapp.component.ui.CarsTopAppBarWithLeftIcon
import com.dmitrystonie.leasingapp.component.ui.ColouredButton
import com.dmitrystonie.leasingapp.component.ui.ColouredCard
import com.dmitrystonie.leasingapp.component.ui.LineProgressIndicator
import com.dmitrystonie.leasingapp.component.ui.RentPrice
import com.dmitrystonie.leasingapp.leasing.presentation.BookingViewModel
import com.dmitrystonie.leasingapp.leasing.presentation.dto.BookingData
import com.dmitrystonie.leasingapp.leasing.presentation.dto.ContactsData
import com.dmitrystonie.leasingapp.ui.theme.BgBrand
import com.dmitrystonie.leasingapp.ui.theme.BgPrimary
import com.dmitrystonie.leasingapp.ui.theme.BorderLight
import com.dmitrystonie.leasingapp.ui.theme.TextInvert
import com.dmitrystonie.leasingapp.util.daysDuration
import com.dmitrystonie.leasingapp.util.fromDate
import com.dmitrystonie.leasingapp.util.toDate


@Composable
fun LeasingConfirmationScreen(
    carId: String,
    onBackClick: () -> Unit,
    onSubmitClick: () -> Unit,
    onChangeBookingData: () -> Unit,
    onChangeContactsData: () -> Unit
) {
    val viewModel: BookingViewModel =
        hiltViewModel<BookingViewModel, BookingViewModel.BookingViewModelFactory> { factory ->
            factory.create(carId)
        }

    val modifier = Modifier.padding(start = 16.dp, end = 16.dp)

    Column(
        modifier = Modifier.background(BgPrimary)

    ) {
        TopBar(onBackClick)

        Indicator(modifier = modifier.padding(top = 24.dp))

//      not completed
//        BookingCard(
//            modifier = modifier.padding(top = 24.dp),
//            onClick = onChangeBookingData,
//            carName = "",
//            bookingData = T,
//        )
//
//        ContactsField(
//            modifier = modifier.padding(top = 24.dp),
//            onClick = onChangeContactsData,
//            contactsData = TODO(),
//        )
//
//        PriceField(
//            modifier = modifier.padding(top = 24.dp), carPrice = TODO(), rent = TODO()
//        )

        ConfirmButton(
            modifier = modifier, onClick = onSubmitClick
        )

    }

}

@Composable
fun TopBar(onClick: () -> Unit) {
    CarsTopAppBarWithLeftIcon(
        text = stringResource(R.string.leasing_screen_step_3_title),
        icon = painterResource(R.drawable.cross),
        iconColor = BorderLight,
        description = stringResource(R.string.leasing_back_description),
        onClick = onClick
    )
}

@Composable
fun ConfirmButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    ColouredButton(
        modifier = modifier,
        onClick = onClick,
        buttonColors = ButtonColors(
            containerColor = BgBrand,
            contentColor = TextInvert,
            disabledContainerColor = BgBrand,
            disabledContentColor = TextInvert
        ),
        text = stringResource(R.string.leasing_draw_up_button_text),
    )
}

@Composable
fun PriceField(modifier: Modifier = Modifier, carPrice: Int, rent: Rent) {
    RentPrice(
        modifier = modifier, price = carPrice * rent.daysDuration(), rent = Rent(
            startDate = System.currentTimeMillis(),
            endDate = System.currentTimeMillis() + 14 * 1000 * 60 * 60 * 24
        )
    )
}

@Composable
fun ContactsField(modifier: Modifier = Modifier, onClick: () -> Unit, contactsData: ContactsData) {
    ColouredCard(
        onTitleClick = onClick,
        title = stringResource(R.string.leasing_leasing_contacts_text),
        items = listOf(
            CardItemDto(
                title = stringResource(R.string.leasing_full_name_headline),
                text = stringResource(
                    R.string.leasing_name_template,
                    contactsData.lastName!!,
                    contactsData.firstName!!,
                    contactsData.middleName!!
                ),
            ),
            CardItemDto(
                title = stringResource(R.string.leasing_birthdate_headline),
                text = contactsData.birthDate!!
            ),
            CardItemDto(
                title = stringResource(R.string.leasing_phone_number_headline),
                text = contactsData.phone!!
            ),
            CardItemDto(
                title = stringResource(R.string.leasing_email_headline), text = contactsData.email!!
            ),
            CardItemDto(
                title = stringResource(R.string.leasing_comment_headline),
                text = contactsData.comment!!
            ),
        )
    )
}

@Composable
fun BookingCard(
    modifier: Modifier = Modifier, onClick: () -> Unit, carName: String, bookingData: BookingData
) {
    ColouredCard(
        onTitleClick = onClick,
        title = stringResource(R.string.leasing_leasing_info_text),
        items = listOf(
            CardItemDto(
                title = stringResource(R.string.leasing_car_headline), text = carName
            ),
            CardItemDto(
                title = stringResource(R.string.leasing_leasing_dates_headline),
                text = stringResource(
                    R.string.leasing_leasing_dates_template,
                    bookingData.rent!!.fromDate(),
                    bookingData.rent.toDate()
                )
            ),
            CardItemDto(
                title = stringResource(R.string.leasing_place_of_receipt_headline),
                text = bookingData.pickupLocation!!
            ),
            CardItemDto(
                title = stringResource(R.string.leasing_place_of_return_headline),
                text = bookingData.returnLocation!!
            ),
        )
    )
}

@Composable
fun Indicator(modifier: Modifier = Modifier) {
    LineProgressIndicator(
        modifier = modifier, progress = 1f, title = stringResource(R.string.leasing_step_text, 3, 3)
    )
}