package com.taylorm.s169382.di

import android.content.Context
import androidx.room.Room
import com.taylorm.dissertation.data.local.DissertationDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
Dagger Hilt module providing database dependencies.
 */

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    /*
    Provides an instance of DissertationDatabase using Room's databaseBuilder method.
    Specifies the context, class and name of the database.
     */
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context = context.applicationContext,
        klass = DissertationDatabase::class.java, name = "dissertationDB").build()

    /*
    Provides an instance of the ProviderDao by accessing the ProviderDao method in the DissertationDatabase class.
     */
    @Provides
    @Singleton
    fun providesProviderDao (database: DissertationDatabase) = database.getFavoriteDao()

    /*
    Provides an instance of the LocationDao by accessing the LocationDao method in the DissertationDatabase class.
     */
    @Provides
    @Singleton
    fun providesLocationDao (database: DissertationDatabase) = database.getLocationDao()

    /*
    These dependencies will be available for injection throughout the app.
     */
}