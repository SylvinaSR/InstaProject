package com.sylvieprojects.instaproject.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sylvieprojects.instaproject.R
import com.sylvieprojects.instaproject.domain.models.Pokemon
import com.sylvieprojects.instaproject.view.core.components.InstaIcon
import com.sylvieprojects.instaproject.view.core.components.InstaTextSmall
import com.sylvieprojects.instaproject.view.core.components.InstaUserPhoto

@Preview(showSystemUi = true)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, homeViewModel: HomeViewModel = viewModel()) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    val uiState by produceState<HomeUiState>(
        initialValue = HomeUiState.Start,
        key1 = lifecycle,
        key2 = homeViewModel
    ) {
        lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
            homeViewModel.uiState.collect {
                value = it
            }
        }
    }

    when (val state = uiState) {
        HomeUiState.Loading -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.onBackground,
                    strokeWidth = 5.dp,
                    trackColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        is HomeUiState.Success -> {
            Column(modifier = modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    InstaIcon(
                        modifier = Modifier.size(100.dp),
                        painter = painterResource(R.drawable.instagram_title)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    InstaIcon(
                        imageVector = Icons.Default.FavoriteBorder
                    )
                    Spacer(modifier = Modifier.width(18.dp))
                    InstaIcon(
                        imageVector = Icons.Default.Send
                    )
                }
                ListStories(state.pokemons)
                ListPosts(state.pokemons)
            }
        }

        is HomeUiState.Error -> {}
        HomeUiState.Start -> {}
    }
}

@Composable
fun ListStories(pokemons: List<Pokemon>) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(pokemons) {
            Column(
                modifier = Modifier.padding(horizontal = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                InstaUserPhoto(
                    size = 80.dp,
                    borderSize = 3.dp,
                    padding = 6.dp,
                    image = R.drawable.ic_launcher_background
                )
                Spacer(modifier = Modifier.height(4.dp))
                InstaTextSmall(text = it.name)
            }
        }
    }
}

@Composable
fun ListPosts(pokemons: List<Pokemon>) {
    LazyColumn {
        items(pokemons) {
            ItemPost(it)
        }
    }
}

@Composable
fun ItemPost(post: Pokemon) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
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
                image = R.drawable.ic_launcher_background
            )
            Spacer(modifier = Modifier.width(4.dp))
            InstaTextSmall(text = post.name, fontWeight = FontWeight.SemiBold)
        }
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            painter = painterResource(R.drawable.ic_launcher_background),
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
            InstaIcon(imageVector = Icons.Default.Info)
        }
    }
}

@Composable
fun IconAndCount(
    modifier: Modifier,
    icon: ImageVector,
    count: String
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        InstaIcon(imageVector = icon)
        Spacer(modifier = Modifier.width(4.dp))
        InstaTextSmall(
            text = count,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}


