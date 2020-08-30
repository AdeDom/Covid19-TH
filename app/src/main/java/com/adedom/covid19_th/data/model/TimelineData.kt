package com.adedom.covid19_th.data.model

import com.google.gson.annotations.SerializedName

data class TimelineData(
        @SerializedName("Confirmed") val confirmed: Int? = null,
        @SerializedName("Date") val date: String? = null,
        @SerializedName("Deaths") val deaths: Int? = null,
        @SerializedName("Hospitalized") val hospitalized: Int? = null,
        @SerializedName("NewConfirmed") val newConfirmed: Int? = null,
        @SerializedName("NewDeaths") val newDeaths: Int? = null,
        @SerializedName("NewHospitalized") val newHospitalized: Int? = null,
        @SerializedName("NewRecovered") val newRecovered: Int? = null,
        @SerializedName("Recovered") val recovered: Int? = null,
)
