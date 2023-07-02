package com.taylorm.dissertation.data.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NominatedIndividual(
    @Json(name = "personFamilyName")
    val personFamilyName: String,
    @Json(name = "personGivenName")
    val personGivenName: String,
    @Json(name = "personTitle")
    val personTitle: String
)