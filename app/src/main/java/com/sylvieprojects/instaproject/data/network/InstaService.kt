package com.sylvieprojects.instaproject.data.network

import com.sylvieprojects.instaproject.domain.models.Pokemon
import com.sylvieprojects.instaproject.domain.models.toModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InstaService @Inject constructor(private val apiClient: InstaClient) {

    suspend fun getPokemonList(): List<Pokemon> = withContext(Dispatchers.IO) {
        val response = apiClient.getPokemonList(limit = 20, offset = 0)
        response.body().toModel()
    }

}