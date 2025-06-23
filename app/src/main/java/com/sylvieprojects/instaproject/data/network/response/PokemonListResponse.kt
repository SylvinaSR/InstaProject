package com.sylvieprojects.instaproject.data.network.response

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    @SerializedName("results")
    val results: List<PokemonData>?
)

data class PokemonData(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)
