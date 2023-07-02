package com.taylorm.dissertation.data.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Contact(
    @Json(name = "personFamilyName")
    val personFamilyName: String,
    @Json(name = "personGivenName")
    val personGivenName: String,
    @Json(name = "personRoles")
    val personRoles: List<String>,
    @Json(name = "personTitle")
    val personTitle: String
)