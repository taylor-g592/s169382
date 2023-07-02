package com.taylorm.dissertation.data.api.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrentRatings(
    @Json(name = "overall")
    val overall: Overall,
    @Json(name = "serviceRatings")
    val serviceRatings: List<ServiceRating>
)