package com.taylorm.dissertation.data.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegulatedActivity(
    @Json(name = "code")
    val code: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "nominatedIndividual")
    val nominatedIndividual: NominatedIndividual
)