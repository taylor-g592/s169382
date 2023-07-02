package com.taylorm.dissertation.data.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Report(
    @Json(name = "firstVisitDate")
    val firstVisitDate: String,
    @Json(name = "linkId")
    val linkId: String,
    @Json(name = "relatedDocuments")
    val relatedDocuments: List<RelatedDocument>,
    @Json(name = "reportDate")
    val reportDate: String,
    @Json(name = "reportType")
    val reportType: String,
    @Json(name = "reportUri")
    val reportUri: String
)