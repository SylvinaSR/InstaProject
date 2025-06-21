package com.sylvieprojects.instaproject.domain.models

import androidx.annotation.DrawableRes

data class Stori(
    val userNickName: String,
    @DrawableRes val userImage: Int,
    var isSeen: Boolean = false
)
