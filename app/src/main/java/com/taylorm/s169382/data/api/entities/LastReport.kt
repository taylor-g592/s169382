package com.taylorm.dissertation.data.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LastReport(
    @Json(name = "publicationDate")
    val publicationDate: String
)