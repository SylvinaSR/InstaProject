package com.sylvieprojects.instaproject.domain.models

import androidx.annotation.DrawableRes

class Post(
    val userNickName: String,
    @DrawableRes val userImage: Int,
    @DrawableRes val imagePost: Int,
    val likes: String,
    val comments: String,
    val shared: String
)