package com.sylvieprojects.instaproject.common

import com.sylvieprojects.instaproject.domain.models.NavItem

object InstaUtils {

    fun getNavItemById(id: Int): NavItem {
        return when (id) {
            NavItem.HOME.idScreen -> NavItem.HOME
            NavItem.SEARCH.idScreen -> NavItem.SEARCH
            NavItem.CREATE.idScreen -> NavItem.CREATE
            NavItem.REELS.idScreen -> NavItem.REELS
            NavItem.PROFILE.idScreen -> NavItem.PROFILE
            else -> NavItem.HOME
        }
    }

}