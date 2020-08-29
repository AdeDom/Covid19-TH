package com.adedom.covid19_th.data.repository

import com.adedom.covid19_th.data.model.Covid19Response
import com.adedom.covid19_th.data.network.Covid19Api

class DefaultCovid19RepositoryImpl(private val api: Covid19Api) : DefaultCovid19Repository {

    override suspend fun fetchCovid19(): Covid19Response = api.fetchCovid19()

}
