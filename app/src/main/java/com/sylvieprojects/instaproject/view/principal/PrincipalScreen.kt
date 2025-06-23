package com.sylvieprojects.instaproject.view.principal

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sylvieprojects.instaproject.common.InstaUtils.getNavItemById
import com.sylvieprojects.instaproject.domain.models.NavItem
import com.sylvieprojects.instaproject.view.core.components.InstaIcon
import com.sylvieprojects.instaproject.view.core.components.InstaUserPhoto
import com.sylvieprojects.instaproject.view.home.HomeScreen

@Preview(showSystemUi = true)
@Composable
fun PrincipalScreen() {
    Scaffold(
        bottomBar = { InstaNavigationBar() }
    ) { innerPadding ->
        HomeScreen(modifier = Modifier.padding(paddingValues = innerPadding))
    }
}

@Composable
fun InstaNavigationBar() {
    val items = List(5) { it }
    var selectedIndex by remember { mutableIntStateOf(0) }
    NavigationBar(containerColor = MaterialTheme.colorScheme.background, tonalElevation = 10.dp) {
        items.forEachIndexed { index, item ->
            MyItemNavBar(navItem = item, isSelected = index == selectedIndex) {
                selectedIndex = index
            }
        }
    }
}

@Composable
fun RowScope.MyItemNavBar(navItem: Int, isSelected: Boolean, onItemClick: () -> Unit) {
    NavigationBarItem(
        selected = isSelected,
        onClick = { onItemClick() },
        icon = {
            getNavItemById(navItem).let {
                if (navItem == NavItem.PROFILE.idScreen) {
                    InstaUserPhoto(
                        size = 24.dp,
                        borderSize = 0.dp,
                        padding = 0.dp,
                        image = it.profileImage
                    )
                } else {
                    Icon(imageVector = it.icon, contentDescription = null)
                }
            }
        },
        alwaysShowLabel = false,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unselectedIconColor = MaterialTheme.colorScheme.onBackground,
            indicatorColor = Color.Transparent
        )
    )
}



