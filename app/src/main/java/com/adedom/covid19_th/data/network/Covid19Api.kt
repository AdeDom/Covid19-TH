package com.adedom.covid19_th.data.network

import com.adedom.covid19_th.data.model.Covid19Response
import retrofit2.http.GET

interface Covid19Api {

    @GET("/api/open/today")
    suspend fun fetchCovid19(): Covid19Response

}
