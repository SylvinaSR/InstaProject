package com.sylvieprojects.instaproject.view.auth.signUp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sylvieprojects.instaproject.R
import com.sylvieprojects.instaproject.view.core.components.InstaButton
import com.sylvieprojects.instaproject.view.core.components.InstaOutlinedButton
import com.sylvieprojects.instaproject.view.core.components.InstaOutlinedTextField
import com.sylvieprojects.instaproject.view.core.components.InstaText
import com.sylvieprojects.instaproject.view.core.components.InstaTextSmall
import com.sylvieprojects.instaproject.view.core.components.InstaTitles

@Composable
fun SignUpScreen(signUpViewModel: SignUpViewModel = viewModel(), navigateBack: () -> Unit) {

    val uiState by signUpViewModel.uiState.collectAsStateWithLifecycle()

    val title: String
    val description: String
    val optionLabel: String
    val notifications: String
    val register: String
    val keyboardOption: KeyboardOptions

    when (uiState.isPhoneOption) {
        true -> {
            title = stringResource(R.string.signup_screen_title_phone)
            description = stringResource(R.string.signup_screen_description_phone)
            optionLabel = stringResource(R.string.signup_screen_label_number)
            notifications = stringResource(R.string.signup_screen_text_notifications_phone)
            register = stringResource(R.string.signup_screen_button_register_email)
            keyboardOption = KeyboardOptions(keyboardType = KeyboardType.Phone)
        }

        false -> {
            title = stringResource(R.string.signup_screen_title_email)
            description = stringResource(R.string.signup_screen_description_email)
            optionLabel = stringResource(R.string.signup_screen_label_email)
            notifications = stringResource(R.string.signup_screen_text_notifications_email)
            register = stringResource(R.string.signup_screen_button_register_phone)
            keyboardOption = KeyboardOptions(keyboardType = KeyboardType.Email)
        }
    }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .padding(top = 12.dp, bottom = 16.dp)
        ) {
            Icon(
                modifier = Modifier.clickable {
                    navigateBack()
                },
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(12.dp))
            InstaTitles(
                text = title,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            InstaText(
                text = description,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(12.dp))
            InstaOutlinedTextField(
                keyboardOptions = keyboardOption,
                value = uiState.inputText,
                label = optionLabel,
                onValueChange = { signUpViewModel.onTextChanged(it) }
            )
            Spacer(modifier = Modifier.height(6.dp))
            InstaTextSmall(
                text = notifications
            )
            Spacer(modifier = Modifier.height(14.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.label_next),
                onClick = {},
                enabled = uiState.isNextEnable
            )
            Spacer(modifier = Modifier.height(12.dp))
            InstaOutlinedButton(
                onClick = { signUpViewModel.onOptionChange() },
                text = register
            )
            Spacer(modifier = Modifier.weight(1f))
            TextButton(modifier = Modifier.fillMaxWidth(), onClick = {}) {
                InstaText(
                    text = stringResource(R.string.signup_screen_text_search_account),
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}