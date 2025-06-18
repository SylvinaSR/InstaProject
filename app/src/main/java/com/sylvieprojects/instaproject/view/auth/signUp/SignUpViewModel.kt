package com.sylvieprojects.instaproject.view.auth.signUp

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState

    fun onTextChanged(phone: String) {
        _uiState.update { state ->
            state.copy(inputText = phone)
        }
        verifyContent()
    }

    private fun verifyContent() {
        val enableButton =
            if (_uiState.value.isPhoneOption) {
                _uiState.value.inputText.length == 10
            } else {
                isEmailValid(
                    _uiState.value.inputText
                )
            }
        _uiState.update { state ->
            state.copy(isNextEnable = enableButton)
        }
    }

    fun isEmailValid(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun onOptionChange() {
        _uiState.update { state ->
            state.copy(isPhoneOption = !state.isPhoneOption, inputText = "")
        }
        verifyContent()
    }

}

data class SignUpUiState(
    val inputText: String = "",
    val isNextEnable: Boolean = false,
    val isPhoneOption: Boolean = true
)