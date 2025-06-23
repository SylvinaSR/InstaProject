package com.sylvieprojects.instaproject.domain.usecases

import com.sylvieprojects.instaproject.data.repositories.InstaRepository
import com.sylvieprojects.instaproject.domain.models.Pokemon

class GetPokemonsUseCase {

    private val repository = InstaRepository()

    suspend operator fun invoke(): List<Pokemon> = repository.getPokemons()

}