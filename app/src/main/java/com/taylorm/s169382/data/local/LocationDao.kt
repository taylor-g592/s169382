package com.taylorm.s169382.data.local

import androidx.room.*
import com.taylorm.dissertation.data.api.entities.Location
import kotlinx.coroutines.flow.Flow

/*
Data access object for the Location table.
 */
@Dao
interface LocationDao {
    /*
    This function inserts a favourite location into the database.
    If the location already exists, it is replaced.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(location : Location)

    /*
    This function retrieves all favourite locations from the database.
     */
    @Query("select * from location")
    fun getFavorites() : Flow<List<Location>>

    /*
    This function deletes all favourite locations from the database.
     */
    @Query("Delete from location")
    suspend fun deleteAll()

    /*
    This function deletes a favourite location from the database.
     */
    @Delete
    suspend fun delete(location: Location)
}