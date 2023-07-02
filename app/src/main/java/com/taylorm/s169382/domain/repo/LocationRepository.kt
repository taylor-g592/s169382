package com.taylorm.s169382.domain.repo

import com.taylorm.dissertation.data.api.entities.Location
import kotlinx.coroutines.flow.Flow

/*
Repository interface for managing location data.
 */

interface LocationRepository {

    /*
    Returns a flow of favorite locations.
     */
    fun getFavorites() : Flow<List<Location>>

    /*
    Adds a location to favourites.
     */
    suspend fun addToFavorite(location: Location)

    /*
    Removes a location from favourites.
     */
    suspend fun removeFromFavorite(location: Location)
}