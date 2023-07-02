package com.taylorm.s169382.data.local

import androidx.room.*
import com.taylorm.dissertation.data.api.entities.Provider
import kotlinx.coroutines.flow.Flow

/*
Data access object for the Provider table.
 */
@Dao
interface ProviderDao {
    /*
    This function inserts a favourite provider into the database.
    If the provider already exists, it is replaced.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(provider : Provider)

    /*
    This function retrieves all favourite providers from the database.
     */
    @Query("select * from Provider")
    fun getFavorites() : Flow<List<Provider>>

    /*
    This function deletes all favourite providers from the database.
     */
    @Query("Delete from Provider")
    suspend fun deleteAll()

    /*
    This function deletes a favourite provider from the database.
     */
    @Delete
    suspend fun delete(provider: Provider)
}