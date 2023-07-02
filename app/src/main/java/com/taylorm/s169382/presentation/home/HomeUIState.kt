package com.taylorm.s169382.presentation.home

import com.taylorm.dissertation.data.api.entities.ProviderApiResponse

/*
Sealed interface for the states that can be displayed in the home screen.
 */

sealed interface HomeUIState {
    object Loading : HomeUIState
    class ErrorState(val message: String?) : HomeUIState
    class SuccessState(val providers: ProviderApiResponse) : HomeUIState
}