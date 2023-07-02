package com.taylorm.dissertation.data.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Relationship(
    @Json(name = "reason")
    val reason: String,
    @Json(name = "relatedProviderId")
    val relatedProviderId: String,
    @Json(name = "relatedProviderName")
    val relatedProviderName: String,
    @Json(name = "type")
    val type: String
)