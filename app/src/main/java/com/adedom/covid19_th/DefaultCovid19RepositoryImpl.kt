package com.adedom.covid19_th

class DefaultCovid19RepositoryImpl(private val api: Covid19Api) : DefaultCovid19Repository {

    override suspend fun fetchCovid19(): Covid19Response = api.fetchCovid19()

}
