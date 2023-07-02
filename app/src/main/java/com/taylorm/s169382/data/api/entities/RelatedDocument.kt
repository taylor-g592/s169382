package com.taylorm.dissertation.data.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RelatedDocument(
    @Json(name = "documentType")
    val documentType: String,
    @Json(name = "documentUri")
    val documentUri: String
)