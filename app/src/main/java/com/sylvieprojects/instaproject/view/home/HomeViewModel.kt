package com.sylvieprojects.instaproject.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sylvieprojects.instaproject.domain.models.Pokemon
import com.sylvieprojects.instaproject.domain.usecases.GetPokemonsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val getPokemonsUseCase = GetPokemonsUseCase()

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Start)
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        getPokemonList()
    }

    fun getPokemonList() {
        _uiState.value = HomeUiState.Loading
        viewModelScope.launch {
            val result = getPokemonsUseCase.invoke()
            if (result.isNotEmpty()) {
                _uiState.value = HomeUiState.Success(result)
            } else {
                _uiState.value = HomeUiState.Error("No hay pokemons")
            }
        }
    }

}

sealed class HomeUiState {
    object Start : HomeUiState()
    object Loading : HomeUiState()
    data class Success(val pokemons: List<Pokemon>) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}