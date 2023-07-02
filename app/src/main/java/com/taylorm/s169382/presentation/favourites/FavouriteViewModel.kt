package com.taylorm.s169382.presentation.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taylorm.s169382.domain.usecases.GetProviderFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
ViewModel for the favourites screen.
 */

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val useCase: GetProviderFavoritesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<FavoriteUIState>(FavoriteUIState.Loading)
    val uiState: StateFlow<FavoriteUIState> = _uiState.asStateFlow()

    fun onEvent(event: FavoriteEvents) {
        when (event) {
            is FavoriteEvents.GetFavoriteProviders -> {
                getFavoriteList()
            }

            else -> {}
        }

    }

    private fun getFavoriteList() {
        _uiState.value = FavoriteUIState.Loading
        viewModelScope.launch {
            useCase.invoke(Unit).collect { providers ->
            if(!providers.isEmpty()){
                _uiState.value = FavoriteUIState.SuccessState(providers)
            }else {
                _uiState.value = FavoriteUIState.EmptyState
            }
            }
        }
    }

}