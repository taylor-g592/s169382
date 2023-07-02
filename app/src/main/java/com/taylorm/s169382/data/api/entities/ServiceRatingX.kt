package com.taylorm.dissertation.data.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ServiceRatingX(
    @Json(name = "keyQuestionRatings")
    val keyQuestionRatings: List<KeyQuestionRatingX>,
    @Json(name = "name")
    val name: String,
    @Json(name = "rating")
    val rating: String
)