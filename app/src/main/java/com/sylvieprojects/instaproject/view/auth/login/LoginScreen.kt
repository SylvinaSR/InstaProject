package com.sylvieprojects.instaproject.view.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sylvieprojects.instaproject.R

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(padding)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 22.dp),
                text = "Español (Latinoamerica)",
                color = Color.Gray
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
                shape = RoundedCornerShape(25),
                value = uiState.email,
                label = {
                    Text("Usuario, correo electrónico o móvil")
                },
                onValueChange = { loginViewModel.onEmailChange(it) })
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(25),
                value = uiState.password,
                label = {
                    Text("Contraseña")
                },
                onValueChange = { loginViewModel.onPasswordChange(it) })
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                enabled = uiState.isLoginEnable
            ) {
                Text(modifier = Modifier.padding(6.dp), text = "Iniciar sesión")
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = {}) {
                Text(text = "¿Has olvidado la contraseña?", fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            OutlinedButton(modifier = Modifier.fillMaxWidth(), onClick = {}) {
                Text(modifier = Modifier.padding(6.dp), text = "Crear cuenta nueva")
            }
            Icon(
                modifier = Modifier.size(80.dp),
                painter = painterResource(R.drawable.ic_meta),
                contentDescription = null,
                tint = Color.Gray
            )
        }
    }
}