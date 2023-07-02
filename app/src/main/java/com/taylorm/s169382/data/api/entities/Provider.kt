package com.taylorm.dissertation.data.api.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "Provider")
data class Provider(
    @field:Json(name = "providerId")
    @PrimaryKey
    val providerId: String,
    @field:Json(name = "providerName")
    val providerName: String,
    var isFavorite : Boolean = false

)