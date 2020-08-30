package com.adedom.covid19_th.data.network

import com.adedom.covid19_th.data.response.Covid19Response
import com.adedom.covid19_th.data.response.TimelineResponse
import retrofit2.http.GET

interface Covid19Api {

    @GET("/api/open/today")
    suspend fun fetchCovid19(): Covid19Response

    @GET("/api/open/timeline")
    suspend fun fetchTimeline(): TimelineResponse

}
