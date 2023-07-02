package com.taylorm.s169382.data.api

import com.taylorm.dissertation.data.api.entities.GetLocationResponse
import com.taylorm.dissertation.data.api.entities.ProviderApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CqcService {
    /*
    This function retrieves a list of providers from the CQC API.
    Returns GetProviderResponse object.
     */
    @GET("/public/v1/providers")
    suspend fun getProvider(@Query("page") page: String, @Query("perPage") perPage: String,
                            @Query("partnerCode") partnerCode: String = "OpenAnswers", ): ProviderApiResponse

    /*
    This function retrieves a list of locations from the CQC API.
    Returns GetLocationResponse object.
     */
    @GET("/public/v1/locations")
    suspend fun getLocations(@Query("page") page: String, @Query("perPage") perPage: String,
                             @Query("partnerCode") partnerCode: String = "OpenAnswers") : GetLocationResponse

}