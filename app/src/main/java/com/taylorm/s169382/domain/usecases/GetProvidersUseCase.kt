package com.taylorm.s169382.domain.usecases

import com.taylorm.dissertation.data.DataResource
import com.taylorm.dissertation.data.api.entities.ProviderApiResponse
import com.taylorm.dissertation.data.api.entities.ProviderRequest
import com.taylorm.dissertation.domain.repo.CQCRepository
import com.taylorm.s169382.data.DataResource
import com.taylorm.s169382.domain.repo.CQCRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

/*
Use case for retrieving providers based on the provided request from the CQCRepository.
 */

class GetProvidersUseCase (
    private val repository : CQCRepository,
    private val dispatcher : CoroutineDispatcher)
    : FlowUseCase<ProviderRequest, DataResource<ProviderApiResponse>>(dispatcher){
    override fun execute(parameters: ProviderRequest): Flow<DataResource<ProviderApiResponse>> {

        /*
        Executes the use case with the specified parameters.
        Returns a flow of DataResource<ProviderApiResponse>.
         */
       return repository.getProvider(parameters)
    }

}