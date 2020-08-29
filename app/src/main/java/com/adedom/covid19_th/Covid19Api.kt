package com.adedom.covid19_th

import retrofit2.http.GET

interface Covid19Api {

    @GET("/api/open/today")
    suspend fun fetchCovid19(): Covid19Response

}
