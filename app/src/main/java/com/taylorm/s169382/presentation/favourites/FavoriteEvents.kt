package com.taylorm.s169382.presentation.favourites



/*
Sealed interface for the events that can be triggered in the favourites screen.
 */

sealed interface FavoriteEvents{
    object GetFavoriteProviders : FavoriteEvents
}