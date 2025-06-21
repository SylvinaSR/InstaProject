package com.sylvieprojects.instaproject.view.core.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun InstaText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(modifier = modifier, text = text, color = color, style = style, fontWeight = fontWeight)
}

@Composable
fun InstaTitles(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = MaterialTheme.typography.titleMedium
) {
    Text(modifier = modifier, text = text, color = color, style = style)
}

@Composable
fun InstaTextSmall(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle = MaterialTheme.typography.bodySmall,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(modifier = modifier, text = text, color = color, style = style, fontWeight = fontWeight)
}

@Composable
fun InstaTextLabelMedium(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    style: TextStyle = MaterialTheme.typography.labelSmall
) {
    Text(modifier = modifier, text = text, color = color, style = style)
}
