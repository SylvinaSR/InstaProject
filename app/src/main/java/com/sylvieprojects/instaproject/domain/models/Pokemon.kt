package com.sylvieprojects.instaproject.domain.models

import com.sylvieprojects.instaproject.data.network.response.PokemonListResponse
import kotlin.random.Random

data class Pokemon(
    val name: String,
    val url: String,
    val likes: String,
    val comments: String,
    val shared: String
)

fun PokemonListResponse?.toModel(): List<Pokemon> {
    if (this?.results == null) return emptyList()
    val list = mutableListOf<Pokemon>()
    this.results.forEach { pokemon ->
        list.add(
            Pokemon(
                name = pokemon.name ?: "",
                url = pokemon.url ?: "",
                likes = Random.nextInt(1, 1001).toString(),
                comments= Random.nextInt(1, 1001).toString(),
                shared = Random.nextInt(1, 1001).toString()
            )
        )
    }
    return list
}
