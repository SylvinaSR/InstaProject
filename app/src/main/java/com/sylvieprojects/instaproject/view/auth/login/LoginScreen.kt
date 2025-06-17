package com.sylvieprojects.instaproject.view.auth.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sylvieprojects.instaproject.R
import com.sylvieprojects.instaproject.view.core.components.InstaButton
import com.sylvieprojects.instaproject.view.core.components.InstaText

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InstaText(
                modifier = Modifier.padding(top = 22.dp),
                text = "Español (Latinoamerica)"
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier.size(60.dp),
                painter = painterResource(R.drawable.instaproject_logo),
                contentDescription = null
            )
            Spacer(modifier = Modifier.weight(1f))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.large,
                value = uiState.email,
                label = { InstaText(text = "Usuario, correo electrónico o móvil") },
                onValueChange = { loginViewModel.onEmailChange(it) })
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.large,
                value = uiState.password,
                label = {
                    InstaText(text = "Contraseña")
                },
                onValueChange = { loginViewModel.onPasswordChange(it) })
            Spacer(modifier = Modifier.height(12.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Iniciar sesión",
                onClick = {},
                enabled = uiState.isLoginEnable
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = {}) {
                InstaText(text = "¿Has olvidado la contraseña?")
            }
            Spacer(modifier = Modifier.weight(1f))
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                InstaText(
                    modifier = Modifier.padding(6.dp),
                    text = "Crear cuenta nueva",
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Icon(
                modifier = Modifier.size(80.dp),
                painter = painterResource(R.drawable.ic_meta),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}