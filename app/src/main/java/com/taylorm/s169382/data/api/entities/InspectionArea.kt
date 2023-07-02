package com.taylorm.dissertation.data.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InspectionArea(
    @Json(name = "endDate")
    val endDate: String,
    @Json(name = "inspectionAreaId")
    val inspectionAreaId: String,
    @Json(name = "inspectionAreaName")
    val inspectionAreaName: String,
    @Json(name = "inspectionAreaType")
    val inspectionAreaType: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "supersededBy")
    val supersededBy: List<String>
)