package com.adedom.covid19_th.data.response

import com.google.gson.annotations.SerializedName

data class Covid19Response(
        @SerializedName("Confirmed") val confirmed: Int? = null,
        @SerializedName("Recovered") val recovered: Int? = null,
        @SerializedName("Hospitalized") val hospitalized: Int? = null,
        @SerializedName("Deaths") val deaths: Int? = null,
        @SerializedName("NewConfirmed") val newConfirmed: Int? = null,
        @SerializedName("NewRecovered") val newRecovered: Int? = null,
        @SerializedName("NewHospitalized") val newHospitalized: Int? = null,
        @SerializedName("NewDeaths") val newDeaths: Int? = null,
        @SerializedName("UpdateDate") val updateDate: String? = null,
        @SerializedName("Source") val source: String? = null,
)
