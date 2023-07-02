package com.taylorm.s169382.domain.repo

import com.taylorm.dissertation.data.api.entities.*
import com.taylorm.s169382.data.DataResource
import com.taylorm.s169382.data.api.CqcService
import com.taylorm.s169382.data.callApi
import com.taylorm.s169382.data.data
import com.taylorm.s169382.data.local.LocationDao
import com.taylorm.s169382.data.local.ProviderDao
import com.taylorm.s169382.data.succeeded
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.RuntimeException

/*
Implementation of the CQCRepository interface.
This class is responsible for fetching data from the API and the local database.
 */

class CQCRepositoryImpl(
    private val apiService : CqcService,
    private val dao: ProviderDao,
    private val locationDao: LocationDao,
    private val dispatcher: CoroutineDispatcher
) : CQCRepository{

    /*
        Fetches a list of providers from the API.
        @param request - the request object containing the page number and number of items per page.
        @return a flow of DataResource objects containing the result of the API call.
     */
    override fun getProvider(request: ProviderRequest): Flow<DataResource<ProviderApiResponse>> = flow{
        emit(DataResource.Loading) // Emit loading status to the UI.
        val result = callApi {  apiService.getProvider(page = request.page, perPage = request.itemCountPerPage)} // Call API to retrieve provider data.
        if(result.succeeded()){
            //val data = result.data!!
            val providers = dao.getFavorites() // Retrieves favorite providers from the local database.
            val data = markFavoriteProviders(result.data!!, providers.first()) // Mark favourite providers in the API result.
            emit(DataResource.Success(data)) // Emit the result to the UI.
        }else{
            emit(DataResource.Error<Throwable>(RuntimeException("Not Found"))) // Emit an error to the UI.
        }
    }.flowOn(dispatcher) // Perform the flow operations on the coroutine dispatcher.

    /*
    Fetches a list of locations from the API.
     */
    override fun getLocations(request: LocationRequest): Flow<DataResource<GetLocationResponse>> = flow{
        emit(DataResource.Loading)
        val result = callApi {  apiService.getLocations(page = request.page, perPage = request.itemCountPerPage)} // Call API to retrieve location data.
        if(result.succeeded()){
            //val data = result.data!!
            val providers = locationDao.getFavorites()
            val data = markFavoriteLocations(result.data!!, providers.first())
            emit(DataResource.Success(data))
        }else{
            emit(DataResource.Error<Throwable>(RuntimeException("Not Found")))
        }
    }.flowOn(dispatcher)


    /*
    Marks favourite providers in the API result.
     */
    private fun markFavoriteProviders(apiResult : ProviderApiResponse, favoriteProviders : List<Provider>) : ProviderApiResponse {
        if(favoriteProviders.isNotEmpty() && apiResult.providers.isNotEmpty()){
            for (fProvider in favoriteProviders){
                for(item in apiResult.providers){
                    if(fProvider.providerId.equals( item.providerId, true) && fProvider.providerName.equals(item.providerName, true)){
                        item.isFavorite = true
                    }
                }
            }
        }
        /*
        Returns the API result with favourite providers marked.
         */
        return apiResult
    }

    /*
    Marks favourite locations in the API result.
     */
    private fun markFavoriteLocations(apiResult : GetLocationResponse, favoriteLocations : List<Location>) : GetLocationResponse {
        if(favoriteLocations.isNotEmpty() && apiResult.locations.isNotEmpty()){
            for (fProvider in favoriteLocations){
                for(item in apiResult.locations){
                    if(fProvider.locationId.equals( item.locationId, true) && fProvider.locationName.equals(item.locationName, true)){
                        item.isFavorite = true
                    }
                }
            }
        }
        /*
        Returns the API result with favourite locations marked.
         */
        return apiResult
    }


}