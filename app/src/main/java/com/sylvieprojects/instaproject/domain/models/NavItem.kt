package com.sylvieprojects.instaproject.domain.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavItem(
    val idScreen: Int,
    val icon: ImageVector = Icons.Default.Home,
    val profileImage: String = ""
) {
    data object HOME : NavItem(idScreen = 0, icon = Icons.Default.Home)
    data object SEARCH : NavItem(idScreen = 1, icon = Icons.Default.Search)
    data object CREATE : NavItem(idScreen = 2, icon = Icons.Default.AddCircle)
    data object REELS : NavItem(idScreen = 3, icon = Icons.Default.PlayArrow)
    data object PROFILE : NavItem(
        idScreen = 4,
        profileImage = "https://static.wikia.nocookie.net/kiminitodoke/images/9/95/Sawako.PNG/revision/latest?cb=20181209023956"
    )
}