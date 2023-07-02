package com.taylorm.dissertation.data.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Overall(
    @Json(name = "keyQuestionRatings")
    val keyQuestionRatings: List<KeyQuestionRating>,
    @Json(name = "rating")
    val rating: String,
    @Json(name = "reportDate")
    val reportDate: String,
    @Json(name = "reportLinkId")
    val reportLinkId: String,
    @Json(name = "useOfResources")
    val useOfResources: UseOfResources
)