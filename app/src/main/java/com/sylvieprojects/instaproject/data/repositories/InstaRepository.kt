package com.sylvieprojects.instaproject.data.repositories

import com.sylvieprojects.instaproject.data.network.InstaService
import com.sylvieprojects.instaproject.domain.models.Pokemon

class InstaRepository {

    private val api = InstaService()

    suspend fun getPokemons(): List<Pokemon> {
        return api.getPokemonList()
    }

}