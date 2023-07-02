package com.taylorm.s169382.presentation.home

import com.taylorm.dissertation.data.api.entities.Provider

/*
Sealed interface for the events that can be triggered in the home screen.
 */

sealed interface HomeEvents {

    data class GetProviders(val page : String, val perPageItems : String ) : HomeEvents
    data class AddToFavorite(val provider : Provider) : HomeEvents
    data class RemoveFromFavorite(val provider : Provider) : HomeEvents

}