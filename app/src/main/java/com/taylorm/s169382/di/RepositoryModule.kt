package com.taylorm.s169382.di

import com.taylorm.s169382.data.api.CqcService
import com.taylorm.s169382.data.local.LocationDao
import com.taylorm.s169382.data.local.ProviderDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

/*
Dagger Hilt module for providing repository dependencies.
 */

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    /*
    Provides an instance of CQCRepositoryImpl by injecting dependencies.
     */
    @Provides
    @Singleton
    fun provideCQCRepository(
        apiService : CqcService,
        dao : ProviderDao,
        locationDao: LocationDao
    ) = CQCRepositoryImpl(apiService, dao, locationDao, dispatcher = Dispatchers.IO )

    /*
    Provides an instance of ProviderRepositoryImpl by injecting dependencies.
     */
    @Provides
    @Singleton
    fun provideFavoriteRepository(dao : ProviderDao)  =
        ProviderRepositoryImpl(dao = dao, dispatcher = Dispatchers.IO)

}