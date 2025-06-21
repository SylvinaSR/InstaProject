package com.sylvieprojects.instaproject.common

import com.sylvieprojects.instaproject.R
import com.sylvieprojects.instaproject.domain.models.Post
import com.sylvieprojects.instaproject.domain.models.Stori

object InfoDataDummy {

    fun getListStories(): List<Stori> =
        listOf<Stori>(
            Stori(
                userNickName = "rex.coyote",
                userImage = R.drawable.ic_launcher_background
            ),
            Stori(
                userNickName = "_cherriprotein",
                userImage = R.drawable.ic_launcher_background
            ),
            Stori(
                userNickName = "salazar_linares",
                userImage = R.drawable.ic_launcher_background
            ),
            Stori(
                userNickName = "alynana_tattoos",
                userImage = R.drawable.ic_launcher_background
            ),
            Stori(
                userNickName = "prospering",
                userImage = R.drawable.ic_launcher_background
            ),
            Stori(
                userNickName = "retoadventur",
                userImage = R.drawable.ic_launcher_background
            ),
            Stori(
                userNickName = "pitasandia_",
                userImage = R.drawable.ic_launcher_background
            ),
            Stori(
                userNickName = "carlosbelcast",
                userImage = R.drawable.ic_launcher_background
            ),
            Stori(
                userNickName = "kumori_ink",
                userImage = R.drawable.ic_launcher_background
            ),
            Stori(
                userNickName = "programmer.me",
                userImage = R.drawable.ic_launcher_background
            )
        )

    fun getListPosts(): List<Post> =
        listOf(
            Post(
                userNickName = "rex.coyote",
                userImage = R.drawable.ic_launcher_background,
                imagePost = R.drawable.ic_launcher_background,
                likes = "562",
                comments = "75",
                shared = "78"
            ),
            Post(
                userNickName = "_cherriprotein",
                userImage = R.drawable.ic_launcher_background,
                imagePost = R.drawable.ic_launcher_background,
                likes = "65",
                comments = "7",
                shared = "6"
            ),
            Post(
                userNickName = "salazar_linares",
                userImage = R.drawable.ic_launcher_background,
                imagePost = R.drawable.ic_launcher_background,
                likes = "45 mil",
                comments = "3 mil",
                shared = "77"
            ),
            Post(
                userNickName = "alynana_tattoos",
                userImage = R.drawable.ic_launcher_background,
                imagePost = R.drawable.ic_launcher_background,
                likes = "45",
                comments = "55",
                shared = ""
            ),
            Post(
                userNickName = "prospering",
                userImage = R.drawable.ic_launcher_background,
                imagePost = R.drawable.ic_launcher_background,
                likes = "5 mil",
                comments = "6 mil",
                shared = "78"
            ),
            Post(
                userNickName = "retoadventur",
                userImage = R.drawable.ic_launcher_background,
                imagePost = R.drawable.ic_launcher_background,
                likes = "945",
                comments = "65",
                shared = "7"
            ),
            Post(
                userNickName = "pitasandia_",
                userImage = R.drawable.ic_launcher_background,
                imagePost = R.drawable.ic_launcher_background,
                likes = "16 mil",
                comments = "45",
                shared = "5"
            ),
            Post(
                userNickName = "carlosbelcast",
                userImage = R.drawable.ic_launcher_background,
                imagePost = R.drawable.ic_launcher_background,
                likes = "136",
                comments = "7",
                shared = ""
            ),
            Post(
                userNickName = "kumori_ink",
                userImage = R.drawable.ic_launcher_background,
                imagePost = R.drawable.ic_launcher_background,
                likes = "1 mil",
                comments = "877",
                shared = "45"
            ),
            Post(
                userNickName = "programmer.me",
                userImage = R.drawable.ic_launcher_background,
                imagePost = R.drawable.ic_launcher_background,
                likes = "12 mil",
                comments = "789",
                shared = "85"
            )
        )
}