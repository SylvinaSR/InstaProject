package com.sylvieprojects.instaproject.view.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sylvieprojects.instaproject.R

@Composable
fun InstaButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    onClick: () -> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
) {
    Button(
        modifier = modifier,
        colors = colors,
        onClick = { onClick() },
        enabled = enabled,
        shape = shape,
    ) {
        InstaText(
            modifier = Modifier.padding(6.dp),
            text = text,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun InstaOutlinedButton(
    modifier: Modifier = Modifier,
    border: BorderStroke = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
    onClick: () -> Unit,
    text: String
) {
    OutlinedButton(
        modifier = modifier.fillMaxWidth(),
        border = border,
        onClick = { onClick() },
    ) {
        InstaText(
            modifier = Modifier.padding(6.dp),
            text = text,
            color = MaterialTheme.colorScheme.primary
        )
    }
}