package com.adedom.covid19_th.data.repository

import com.adedom.covid19_th.data.network.Covid19Api
import com.adedom.covid19_th.data.response.Covid19Response
import com.adedom.covid19_th.data.response.TimelineResponse

class DefaultCovid19RepositoryImpl(private val api: Covid19Api) : DefaultCovid19Repository {

    override suspend fun fetchCovid19(): Covid19Response = api.fetchCovid19()

    override suspend fun fetchTimeline(): TimelineResponse = api.fetchTimeline()

}
