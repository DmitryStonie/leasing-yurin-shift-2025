package com.dmitrystonie.leasingapp.leasing.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmitrystonie.leasingapp.domain.entity.rent.Rent
import com.dmitrystonie.leasingapp.domain.usecase.RentCarUseCase
import com.dmitrystonie.leasingapp.leasing.presentation.dto.BookingData
import com.dmitrystonie.leasingapp.leasing.presentation.dto.ContactsData
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


@HiltViewModel(assistedFactory = BookingViewModel.BookingViewModelFactory::class)
class BookingViewModel @AssistedInject constructor(
    private val rentCarUseCase: RentCarUseCase,
    @Assisted private val carId: String,
) : ViewModel() {

    private lateinit var rent: Rent
    private lateinit var bookingData: BookingData
    private lateinit var userData: ContactsData

    private val _state = MutableStateFlow<BookingState>(BookingState.Initial)
    val state: StateFlow<BookingState> = _state

    private val _carState = MutableStateFlow<String>("")
    val carState: StateFlow<String> = _carState

    private val _bookingState = MutableStateFlow<BookingData>(
        BookingData(
            rent = null,
            pickupLocation = null,
            returnLocation = null,
        )
    )
    val bookingState: StateFlow<BookingData> = _bookingState

    private val _contactsState = MutableStateFlow<ContactsData>(
        ContactsData(
            lastName = null,
            firstName = null,
            middleName = null,
            birthDate = null,
            phone = null,
            email = null,
            comment = null,
            agreement = null,
        )
    )
    val contactsState: StateFlow<ContactsData> = _contactsState

    fun updatePickupLocation(pickupLocation: String) {
        _bookingState.update { currentState ->
            currentState.copy(
                pickupLocation = pickupLocation
            )
        }
    }

    fun updateReturnLocation(returnLocation: String) {
        _bookingState.update { currentState ->
            currentState.copy(
                returnLocation = returnLocation
            )
        }
    }

    fun updateLastName(lastName: String) {
        _contactsState.update { currentState ->
            currentState.copy(
                lastName = lastName
            )
        }
    }

    fun updateFirstName(firstName: String) {
        _contactsState.update { currentState ->
            currentState.copy(
                firstName = firstName
            )
        }
    }

    fun updateMiddleName(middleName: String) {
        _contactsState.update { currentState ->
            currentState.copy(
                middleName = middleName
            )
        }
    }

    fun updateBirthDate(birthDate: String) {
        _contactsState.update { currentState ->
            currentState.copy(
                birthDate = birthDate
            )
        }
    }

    fun updatePhone(phone: String) {
        _contactsState.update { currentState ->
            currentState.copy(
                phone = phone
            )
        }
    }

    fun updateEmail(email: String) {
        _contactsState.update { currentState ->
            currentState.copy(
                email = email
            )
        }
    }

    fun updateComment(comment: String) {
        _contactsState.update { currentState ->
            currentState.copy(
                comment = comment
            )
        }
    }

    fun updateAgreement(agreement: Boolean) {
        _contactsState.update { currentState ->
            currentState.copy(
                agreement = agreement
            )
        }
    }

    private fun bookCar() {
        viewModelScope.launch {
            try {
                _state.value = BookingState.Loading
                val rent = rentCarUseCase(Rent(
                    carId = carId,
                    status = null,
                    pickupLocation = _bookingState.value.pickupLocation!!,
                    returnLocation = _bookingState.value.returnLocation!!,
                    startDate = _bookingState.value.rent!!.startDate,
                    endDate = _bookingState.value.rent!!.endDate,
                    totalPrice = null,
                    firstName = _contactsState.value.firstName!!,
                    lastName = _contactsState.value.lastName!!,
                    middleName = _contactsState.value.middleName!!,
                    birthDate = _contactsState.value.birthDate!!,
                    email = _contactsState.value.email!!,
                    phone = _contactsState.value.phone!!,
                    comment = _contactsState.value.comment!!
                ))
                _state.value = BookingState.Success(rent)
            } catch (e: Exception) {
                _state.value = BookingState.Error(message = e.message.orEmpty())
            }
        }
    }

    @AssistedFactory
    interface BookingViewModelFactory {
        fun create(carId: String): BookingViewModel
    }
}