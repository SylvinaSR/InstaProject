package com.sylvieprojects.instaproject.view.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

@Composable
fun InstaOutlinedTextField(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.large,
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        shape = shape,
        value = value,
        keyboardOptions = keyboardOptions,
        label = {
            InstaText(text = label)
        },
        onValueChange = {
            onValueChange(it)
        }
    )
}