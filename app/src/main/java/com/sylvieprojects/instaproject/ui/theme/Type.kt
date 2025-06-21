package com.sylvieprojects.instaproject.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sylvieprojects.instaproject.R

// Set of Material typography styles to start with

val wdx = FontFamily(
    Font(R.font.wdx, FontWeight.Normal)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = wdx,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displayLarge = TextStyle(
        fontFamily = wdx,
        fontWeight = FontWeight.Black,
        fontSize = 57.sp
    ),
    titleMedium = TextStyle(
        fontFamily = wdx,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    bodySmall = TextStyle(
        fontFamily = wdx,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    ),
    labelMedium = TextStyle(
        fontFamily = wdx,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    labelSmall = TextStyle(
        fontFamily = wdx,
        fontWeight = FontWeight.Normal,
        fontSize = 8.sp,
    )
)