package com.adedom.covid19_th.data.repository

import com.adedom.covid19_th.data.response.Covid19Response
import com.adedom.covid19_th.data.response.TimelineResponse

interface DefaultCovid19Repository {

    suspend fun fetchCovid19(): Covid19Response

    suspend fun fetchTimeline(): TimelineResponse

}
