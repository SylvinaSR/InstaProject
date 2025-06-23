package com.sylvieprojects.instaproject.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sylvieprojects.instaproject.R
import com.sylvieprojects.instaproject.common.InfoDataDummy
import com.sylvieprojects.instaproject.domain.models.Post
import com.sylvieprojects.instaproject.view.core.components.InstaTextSmall
import com.sylvieprojects.instaproject.view.core.components.InstaUserPhoto

@Preview(showSystemUi = true)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(100.dp),
                painter = painterResource(R.drawable.instagram_title),
                contentDescription = null
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(18.dp))
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = null
            )
        }
        ListStories()
        ListPosts()
    }
}

@Composable
fun ListStories() {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(InfoDataDummy.getListStories()) {
            Column(
                modifier = Modifier.padding(horizontal = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                InstaUserPhoto(
                    size = 80.dp,
                    borderSize = 3.dp,
                    padding = 6.dp,
                    image = it.userImage
                )
                Spacer(modifier = Modifier.height(4.dp))
                InstaTextSmall(text = it.userNickName)
            }
        }
    }
}

@Composable
fun ListPosts() {
    LazyColumn {
        items(InfoDataDummy.getListPosts()) {
            ItemPost(it)
        }
    }
}

@Composable
fun ItemPost(post: Post) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 16.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            InstaUserPhoto(
                size = 40.dp,
                borderSize = 2.dp,
                padding = 4.dp,
                image = post.userImage
            )
            Spacer(modifier = Modifier.width(4.dp))
            InstaTextSmall(text = post.userNickName, fontWeight = FontWeight.SemiBold)
        }
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            painter = painterResource(post.imagePost),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconAndCount(
                modifier = Modifier.weight(1f),
                icon = Icons.Default.FavoriteBorder,
                count = post.likes
            )
            IconAndCount(
                modifier = Modifier.weight(1f),
                icon = Icons.Default.MailOutline,
                count = post.comments
            )
            IconAndCount(
                modifier = Modifier.weight(1f),
                icon = Icons.Default.Send,
                count = post.shared
            )
            Spacer(modifier = Modifier.weight(2f))
            Icon(imageVector = Icons.Default.Info, contentDescription = null)
        }
    }
}

@Composable
fun IconAndCount(
    modifier: Modifier,
    icon: ImageVector,
    count: String,
    contentDescription: String? = null
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = icon, contentDescription = contentDescription)
        Spacer(modifier = Modifier.width(4.dp))
        InstaTextSmall(text = count, fontWeight = FontWeight.SemiBold)
    }
}


