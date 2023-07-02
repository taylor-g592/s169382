package com.taylorm.dissertation.data.api.entities


import com.squareup.moshi.Json

data class GetLocationResponse(
    @Json(name = "firstPageUri")
    val firstPageUri: String,
    @Json(name = "lastPageUri")
    val lastPageUri: String,
    @Json(name = "locations")
    val locations: List<Location>,
    @Json(name = "nextPageUri")
    val nextPageUri: String,
    @Json(name = "page")
    val page: Int,
    @Json(name = "perPage")
    val perPage: Int,
    @Json(name = "previousPageUri")
    val previousPageUri: Any,
    @Json(name = "total")
    val total: Int,
    @Json(name = "totalPages")
    val totalPages: Int,
    @Json(name = "uri")
    val uri: String
)