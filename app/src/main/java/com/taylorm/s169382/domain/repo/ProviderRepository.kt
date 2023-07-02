package com.taylorm.s169382.domain.repo

import com.taylorm.dissertation.data.api.entities.Provider
import kotlinx.coroutines.flow.Flow

/*
Repository interface for managing provider data.
 */

interface ProviderRepository {

    /*
    Returns a flow of favorite providers.
     */
    fun getFavorites() : Flow<List<Provider>>

    /*
    Adds a provider to favourites.
     */
    suspend fun addToFavorite(provider: Provider)

    /*
    Removes a provider from favourites.
     */
    suspend fun removeFromFavorite(provider: Provider)
}