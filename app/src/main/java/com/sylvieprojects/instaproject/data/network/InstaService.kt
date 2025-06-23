package com.sylvieprojects.instaproject.data.network

import com.sylvieprojects.instaproject.domain.models.Pokemon
import com.sylvieprojects.instaproject.domain.models.toModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InstaService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPokemonList(): List<Pokemon> = withContext(Dispatchers.IO) {
        val response = retrofit.create(InstaClient::class.java).getPokemonList(limit = 20, offset = 0)
        response.body().toModel()
    }

}