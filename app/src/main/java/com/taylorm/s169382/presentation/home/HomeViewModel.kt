package com.taylorm.s169382.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taylorm.dissertation.data.api.entities.Provider
import com.taylorm.dissertation.data.api.entities.ProviderRequest
import com.taylorm.s169382.data.onError
import com.taylorm.s169382.data.onLoading
import com.taylorm.s169382.data.onSuccess
import com.taylorm.s169382.domain.usecases.AddFavoriteUseCase
import com.taylorm.s169382.domain.usecases.GetProvidersUseCase
import com.taylorm.s169382.domain.usecases.UnFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
ViewModel for the home screen.
 */

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: GetProvidersUseCase,
                                        private val favoritesUseCase: AddFavoriteUseCase, private val unFavoriteUseCase: UnFavoriteUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUIState>(HomeUIState.Loading)
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()

    fun onEvent(event: HomeEvents) {
        when (event) {
            is HomeEvents.GetProviders -> {
                fetchProviders(event.page, event.perPageItems)
            }
            is HomeEvents.AddToFavorite -> {
                addToFavorite(event.provider)
            }
            is HomeEvents.RemoveFromFavorite ->{
                removeFromFavorite(event.provider)
            }
        }

    }

    private fun fetchProviders(page: String, perPageItems: String) {
        viewModelScope.launch {
            useCase.invoke(
                ProviderRequest(
                    page = "1",
                    itemCountPerPage = "20"
                )
            ).collect { datasource ->
                datasource.onLoading {
                    _uiState.value = HomeUIState.Loading
                    Log.d("API Calling", "Loading")
                }
                datasource.onSuccess {
                    _uiState.value = HomeUIState.SuccessState(this.data)
                    Log.d("API Calling", "Successful")
                }
                datasource.onError {
                    _uiState.value = HomeUIState.ErrorState(this.exception.message)
                    Log.d("API Calling", "Failure")
                }
            }

        }

    }

    private fun addToFavorite(provider : Provider){
        viewModelScope.launch {
            favoritesUseCase.invoke(provider).collect{

            }
        }

    }
    private fun removeFromFavorite(provider : Provider){
        viewModelScope.launch {
            unFavoriteUseCase.invoke(provider).collect{

            }
        }

    }


}