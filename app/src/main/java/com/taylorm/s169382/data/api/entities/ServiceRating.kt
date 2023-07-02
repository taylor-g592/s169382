package com.taylorm.dissertation.data.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ServiceRating(
    @Json(name = "keyQuestionRatings")
    val keyQuestionRatings: List<KeyQuestionRatingX>,
    @Json(name = "name")
    val name: String,
    @Json(name = "organisationId")
    val organisationId: String,
    @Json(name = "rating")
    val rating: String,
    @Json(name = "reportDate")
    val reportDate: String,
    @Json(name = "reportLinkId")
    val reportLinkId: String
)