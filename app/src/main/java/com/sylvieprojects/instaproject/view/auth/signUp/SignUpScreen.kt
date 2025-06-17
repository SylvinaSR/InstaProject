package com.sylvieprojects.instaproject.view.auth.signUp

import androidx.compose.foundation.BorderStroke
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
fun SignUpScreen(signUpViewModel: SignUpViewModel = viewModel()) {
    val uiState by signUpViewModel.uiState.collectAsStateWithLifecycle()
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .padding(top = 12.dp, bottom = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(12.dp))
            InstaTitles(
                text = stringResource(R.string.signup_screen_title),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            InstaText(
                text = stringResource(R.string.signup_screen_description),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.large,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                value = uiState.phoneNumber,
                label = {
                    InstaText(text = stringResource(R.string.signup_screen_label_number))
                },
                onValueChange = { signUpViewModel.onPhoneNumberChange(it) })
            Spacer(modifier = Modifier.height(6.dp))
            InstaTextSmall(text = stringResource(R.string.signup_screen_text_notifications))
            Spacer(modifier = Modifier.height(14.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.label_next),
                onClick = {},
                enabled = uiState.isNextEnable)
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSurfaceVariant)
            ) {
                InstaText(
                    modifier = Modifier.padding(6.dp),
                    text = stringResource(R.string.signup_screen_button_register_email),
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