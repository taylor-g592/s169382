package com.taylorm.s169382.domain.usecases

import com.taylorm.dissertation.data.api.entities.Provider
import com.taylorm.dissertation.domain.repo.ProviderRepositoryImpl
import com.taylorm.s169382.domain.repo.ProviderRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/*
Use case for adding a provider to the favorites list.
 */

class AddFavoriteUseCase(
    private val repository: ProviderRepositoryImpl,
    private val dispatcher: CoroutineDispatcher
) : FlowUseCase<Provider, Unit>(dispatcher) {

    /*
    Executes use case with the specified provider as input params.
     */
    override  fun execute(parameters: Provider): Flow<Unit> {
        return flow {

            /*
            Calls the repository to add the provider to the favorites list.
             */
            repository.addToFavorite(parameters)

            /*
            Emits a unit value to the flow to signal completion.
             */
            emit(Unit)
        }
    }
}

