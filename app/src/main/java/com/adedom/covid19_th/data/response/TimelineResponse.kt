package com.adedom.covid19_th.data.response

import com.adedom.covid19_th.data.model.TimelineData
import com.google.gson.annotations.SerializedName

data class TimelineResponse(
        @SerializedName("Data") val `data`: List<TimelineData> = emptyList(),
        @SerializedName("DevBy") val devBy: String? = null,
        @SerializedName("SeverBy") val severBy: String? = null,
        @SerializedName("Source") val source: String? = null,
        @SerializedName("UpdateDate") val updateDate: String? = null,
)
