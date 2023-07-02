package com.taylorm.dissertation.data.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OverallX(
    @Json(name = "keyQuestionRatings")
    val keyQuestionRatings: List<KeyQuestionRatingX>,
    @Json(name = "rating")
    val rating: String,
    @Json(name = "useOfResources")
    val useOfResources: UseOfResourcesX
)