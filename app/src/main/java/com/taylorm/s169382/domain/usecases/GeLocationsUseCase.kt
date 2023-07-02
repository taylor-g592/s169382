package com.taylorm.s169382.domain.usecases

import com.taylorm.dissertation.data.api.entities.Location
import com.taylorm.dissertation.data.api.entities.Provider
import com.taylorm.dissertation.domain.repo.LocationRepositoryImpl
import com.taylorm.dissertation.domain.repo.ProviderRepositoryImpl
import com.taylorm.s169382.domain.repo.LocationRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

/*
Use case for retrieving favourite locations.
 */

class GeLocationsUseCase(
    private val repository: LocationRepositoryImpl,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
)  : FlowUseCase<Any, List<Location>>(dispatcher){

    /*
    Executes use case with the specified provider as input params.
    Returns a flow of the list of locations.
     */
    override  fun execute(parameters: Any): Flow<List<Location>> {
      return  repository.getFavorites()
    }

}