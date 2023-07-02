package com.taylorm.s169382.domain.repo

import com.taylorm.dissertation.data.api.entities.Provider
import com.taylorm.s169382.data.local.ProviderDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

/*
Implementation of the ProviderRepository interface.
 */
class ProviderRepositoryImpl(
    private val dao: ProviderDao, private val dispatcher: CoroutineDispatcher
) : ProviderRepository {

    /*
    Returns a Flow of all the providers in the database.
     */
    override fun getFavorites(): Flow<List<Provider>> {
        return dao.getFavorites()
    }

    /*
    Adds a provider to the database.
     */
    override suspend fun addToFavorite(provider: Provider) {
        dao.insertFavorite(provider)
    }

    /*
    Removes a provider from the database.
     */
    override suspend fun removeFromFavorite(provider: Provider) {
        dao.delete(provider)
    }

}