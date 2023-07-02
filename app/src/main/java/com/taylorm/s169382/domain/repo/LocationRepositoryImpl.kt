package com.taylorm.s169382.domain.repo

import com.taylorm.dissertation.data.api.entities.Location
import com.taylorm.s169382.data.local.LocationDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

/*
Implementation of LocationRepository interface.
 */

class LocationRepositoryImpl(
    private val dao: LocationDao, private val dispatcher: CoroutineDispatcher
) : LocationRepository {

    /*
    Returns a flow of favorite locations.
     */
    override fun getFavorites(): Flow<List<Location>> {
        return dao.getFavorites()
    }

    /*
    Adds a location to favourites.
     */
    override suspend fun addToFavorite(location: Location) {
        dao.insertFavorite(location)
    }

    /*
    Removes a location from favourites.
     */
    override suspend fun removeFromFavorite(location: Location) {
        dao.delete(location)
    }

}