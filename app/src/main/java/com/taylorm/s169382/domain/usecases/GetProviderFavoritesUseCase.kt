package com.taylorm.s169382.domain.usecases

import com.taylorm.dissertation.data.api.entities.Provider
import com.taylorm.dissertation.domain.repo.ProviderRepositoryImpl
import com.taylorm.s169382.domain.repo.ProviderRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

/*
Use case for retrieving favourite providers.
 */

class GetProviderFavoritesUseCase(
    private val repository: ProviderRepositoryImpl,
    dispatcher: CoroutineDispatcher
)  : FlowUseCase<Any, List<Provider>>(dispatcher){

    /*
    Executes use case with the specified provider as input params.
    Returns a flow of List<Provider>.
     */
    override  fun execute(parameters: Any): Flow<List<Provider>> {

        /*
        Retrieves the list of favorite providers from the repository.
        Returns as a flow.
         */
      return  repository.getFavorites()
    }

}