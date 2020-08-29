package com.adedom.covid19_th.data.repository

import com.adedom.covid19_th.data.model.Covid19Response

interface DefaultCovid19Repository {

    suspend fun fetchCovid19(): Covid19Response

}
