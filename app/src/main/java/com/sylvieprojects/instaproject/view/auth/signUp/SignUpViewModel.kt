package com.sylvieprojects.instaproject.view.auth.signUp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState

    fun onPhoneNumberChange(phone: String) {
        _uiState.update { state ->
            state.copy(phoneNumber = phone)
        }
        verifyPhoneNumber()
    }

    private fun verifyPhoneNumber() {
        val enableButton = _uiState.value.phoneNumber.length == 10
        _uiState.update { state ->
            state.copy(isNextEnable = enableButton)
        }
    }

}

data class SignUpUiState(
    val phoneNumber: String = "",
    val isNextEnable: Boolean = false
)