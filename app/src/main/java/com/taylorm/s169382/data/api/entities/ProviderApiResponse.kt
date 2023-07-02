package com.taylorm.dissertation.data.api.entities

import com.squareup.moshi.Json

data class ProviderApiResponse(
    @field:Json(name = "firstPageUri")
    val firstPageUri: String,
    @field:Json(name = "lastPageUri")
    val lastPageUri: String,
    @field:Json(name = "nextPageUri")
    val nextPageUri: String,
    @field:Json(name = "page")
    val page: Int,
    @field:Json(name = "perPage")
    val perPage: Int,
    @field:Json(name = "previousPageUri")
    val previousPageUri: Any?,
    @field:Json(name = "providers")
    val providers: List<Provider>,
    @field:Json(name = "total")
    val total: Int,
    @field:Json(name = "totalPages")
    val totalPages: Int,
    @field:Json(name = "uri")
    val uri: String
)
