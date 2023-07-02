package com.taylorm.s169382.presentation.favourites

import com.taylorm.dissertation.data.api.entities.Provider

/*
Sealed interface for the states that can be displayed in the favourites screen.
 */

sealed interface FavoriteUIState {

    object Loading : FavoriteUIState
    class ErrorState(val message: String?) : FavoriteUIState
    class SuccessState(val providers: List<Provider>) : FavoriteUIState
    object EmptyState : FavoriteUIState
}