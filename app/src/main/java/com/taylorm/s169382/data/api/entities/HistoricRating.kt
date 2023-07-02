package com.taylorm.dissertation.data.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HistoricRating(
    @Json(name = "organisationId")
    val organisationId: String,
    @Json(name = "overall")
    val overall: OverallX,
    @Json(name = "reportDate")
    val reportDate: String,
    @Json(name = "reportLinkId")
    val reportLinkId: String,
    @Json(name = "serviceRatings")
    val serviceRatings: List<ServiceRatingX>
)