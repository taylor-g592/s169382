package com.taylorm.s169382.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

/*
Dagger Hilt module for providing use case dependencies.
 */

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    /*
    Provides an instance of GetProvidersUseCase by injecting dependencies.
     */
    @Provides
    @Singleton
    fun providesUseCase(repository: CQCRepositoryImpl) =
        GetProvidersUseCase(repository, dispatcher = Dispatchers.IO)

    /*
    Provides an instance of GetProviderFavoritesUseCase by injecting dependencies.
     */
    @Provides
    @Singleton
    fun provideFavoriteUseCase(repository: ProviderRepositoryImpl) =
        GetProviderFavoritesUseCase(repository, dispatcher = Dispatchers.IO)

    /*
    Provides an instance of AddFavoriteUseCase by injecting dependencies.
     */
    @Provides
    @Singleton
    fun provideAddFavoriteUseCase(repository: ProviderRepositoryImpl) =
        AddFavoriteUseCase(repository, dispatcher = Dispatchers.IO)

    /*
    Provides an instance of UnFavoriteUseCase by injecting dependencies.
     */
    @Provides
    @Singleton
    fun provideUnFavoriteUseCase(repository: ProviderRepositoryImpl) =
        UnFavoriteUseCase(repository, dispatcher = Dispatchers.IO)

}