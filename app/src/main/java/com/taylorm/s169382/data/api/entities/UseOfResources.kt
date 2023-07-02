package com.taylorm.dissertation.data.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UseOfResources(
    @Json(name = "combinedQualityRating")
    val combinedQualityRating: String,
    @Json(name = "combinedQualitySummary")
    val combinedQualitySummary: String,
    @Json(name = "reportDate")
    val reportDate: String,
    @Json(name = "reportLinkId")
    val reportLinkId: String,
    @Json(name = "useOfResourcesRating")
    val useOfResourcesRating: String,
    @Json(name = "useOfResourcesSummary")
    val useOfResourcesSummary: String
)