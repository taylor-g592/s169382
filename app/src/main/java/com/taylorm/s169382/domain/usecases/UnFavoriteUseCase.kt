package com.taylorm.s169382.domain.usecases

import com.taylorm.dissertation.data.api.entities.Provider
import com.taylorm.dissertation.domain.repo.ProviderRepositoryImpl
import com.taylorm.s169382.domain.repo.ProviderRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/*
Use case for removing a provider from the favorites list.
 */
class UnFavoriteUseCase(
    private val repository: ProviderRepositoryImpl,
    private val dispatcher: CoroutineDispatcher
) : FlowUseCase<Provider, Unit>(dispatcher) {

    /*
    Executes use case with the specified provider as input params.
     */
    override fun execute(parameters: Provider): Flow<Unit> {
        return flow {
            repository.removeFromFavorite(parameters)
            emit(Unit)
        }
    }
}
