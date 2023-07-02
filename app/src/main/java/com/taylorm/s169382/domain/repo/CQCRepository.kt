package com.taylorm.s169382.domain.repo

import com.taylorm.dissertation.data.api.entities.GetLocationResponse
import com.taylorm.dissertation.data.api.entities.LocationRequest
import com.taylorm.dissertation.data.api.entities.ProviderApiResponse
import com.taylorm.dissertation.data.api.entities.ProviderRequest
import com.taylorm.s169382.data.DataResource
import kotlinx.coroutines.flow.Flow

/*
Repository interface for the CQC API.
 */
interface CQCRepository {

    /*
    Get a provider from the CQC API.
     */
    fun getProvider(request: ProviderRequest): Flow<DataResource<ProviderApiResponse>>

    /*
    Get a location from the CQC API.
     */
    fun getLocations(request: LocationRequest) : Flow<DataResource<GetLocationResponse>>
}

/*
The returned data from the CQC API is wrapped in a Flow<DataResource<T>> object to allow asynchronous, reactive data processing.
Also provides a wrapper for the data to allow for error handling.
 */