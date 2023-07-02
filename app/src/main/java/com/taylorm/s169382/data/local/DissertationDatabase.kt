package com.taylorm.dissertation.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.taylorm.dissertation.data.api.entities.Location
import com.taylorm.dissertation.data.api.entities.Provider
import com.taylorm.s169382.data.local.LocationDao
import com.taylorm.s169382.data.local.ProviderDao

/*
Room database class that manages local data storage.
Database annotation defines the entities that will be stored in the database and the version number.
 */
@Database(entities = [Provider::class, Location::class], version = 1)
abstract class DissertationDatabase  : RoomDatabase(){

    abstract fun getFavoriteDao() : ProviderDao
    abstract fun getLocationDao(): LocationDao
/*
Singleton pattern to ensure only one instance of the database is created.
*/
    /*private late init var INSTANCE : DissertationDatabase

    public fun getInstance(context : Context) : DissertationDatabase {
        if (!this::INSTANCE.isInitialized){
            synchronized(this){

/* Build the DissertationDatabase instance using Room's databaseBuilder method and return the instance.
*/
                INSTANCE = Room.databaseBuilder(context = context.applicationContext,
                klass = DissertationDatabase::class.java, name = "dissertationDB").build()
            }
        }
        return INSTANCE
    }*/


}