package com.taylorm.dissertation.data.api.entities


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity(tableName = "location")
data class Location(
    @PrimaryKey
    @Json(name = "locationId")
    val locationId: String,
    @Json(name = "locationName")
    val locationName: String,
    @Json(name = "postalCode")
    val postalCode: String,
    var isFavorite : Boolean = false
)