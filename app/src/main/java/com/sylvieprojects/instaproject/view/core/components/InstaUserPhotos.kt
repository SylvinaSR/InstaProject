package com.sylvieprojects.instaproject.view.core.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.sylvieprojects.instaproject.ui.theme.InstagramMagenta
import com.sylvieprojects.instaproject.ui.theme.InstagramOrange
import com.sylvieprojects.instaproject.ui.theme.InstagramPink
import com.sylvieprojects.instaproject.ui.theme.InstagramRed
import com.sylvieprojects.instaproject.ui.theme.InstagramSecondaryYellow
import com.sylvieprojects.instaproject.ui.theme.InstagramYellow

@Composable
fun InstaUserPhoto(
    modifier: Modifier = Modifier,
    size: Dp,
    borderSize: Dp,
    padding: Dp,
    @DrawableRes image: Int,
    contentDescription: String? = null
) {
    Image(
        modifier = modifier
            .size(size)
            .border(
                width = borderSize,
                brush = Brush.linearGradient(
                    colors = listOf(
                        InstagramSecondaryYellow,
                        InstagramYellow,
                        InstagramOrange,
                        InstagramRed,
                        InstagramPink,
                        InstagramMagenta
                    ),
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(Float.POSITIVE_INFINITY, 0f)
                ),
                shape = CircleShape
            )
            .padding(padding)
            .clip(CircleShape),
        painter = painterResource(image),
        contentDescription = contentDescription
    )
}