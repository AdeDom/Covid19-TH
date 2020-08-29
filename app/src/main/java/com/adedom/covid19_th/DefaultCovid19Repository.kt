package com.adedom.covid19_th

interface DefaultCovid19Repository {

    suspend fun fetchCovid19(): Covid19Response

}
