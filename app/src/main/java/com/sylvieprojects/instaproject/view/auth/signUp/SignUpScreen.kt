package com.sylvieprojects.instaproject.view.auth.signUp

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
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
import com.sylvieprojects.instaproject.view.core.components.InstaText
import com.sylvieprojects.instaproject.view.core.components.InstaTextSmall
import com.sylvieprojects.instaproject.view.core.components.InstaTitles

@Composable
fun SignUpScreen(signUpViewModel: SignUpViewModel = viewModel(), navigateBack: () -> Unit) {
    val uiState by signUpViewModel.uiState.collectAsStateWithLifecycle()
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
                text = if (uiState.isPhoneOption) stringResource(R.string.signup_screen_title_phone) else stringResource(
                    R.string.signup_screen_title_email
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            InstaText(
                text = if (uiState.isPhoneOption) stringResource(R.string.signup_screen_description_phone) else stringResource(
                    R.string.signup_screen_description_email
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.large,
                keyboardOptions = KeyboardOptions(keyboardType = if (uiState.isPhoneOption) KeyboardType.Phone else KeyboardType.Email),
                value = uiState.inputText,
                label = {
                    InstaText(
                        text = if (uiState.isPhoneOption) stringResource(R.string.signup_screen_label_number) else stringResource(
                            R.string.signup_screen_label_email
                        )
                    )
                },
                onValueChange = { signUpViewModel.onTextChanged(it) })
            Spacer(modifier = Modifier.height(6.dp))
            InstaTextSmall(
                text = if (uiState.isPhoneOption) stringResource(R.string.signup_screen_text_notifications_phone) else stringResource(
                    R.string.signup_screen_text_notifications_email
                )
            )
            Spacer(modifier = Modifier.height(14.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.label_next),
                onClick = {},
                enabled = uiState.isNextEnable
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { signUpViewModel.onOptionChange() },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurfaceVariant)
            ) {
                InstaText(
                    modifier = Modifier.padding(6.dp),
                    text = if (uiState.isPhoneOption) stringResource(R.string.signup_screen_button_register_email) else stringResource(
                        R.string.signup_screen_button_register_phone
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
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