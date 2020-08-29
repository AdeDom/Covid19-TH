package com.adedom.covid19_th

import io.reactivex.Single
import retrofit2.http.GET

interface Covid19Api {

    @GET("/api/open/today")
    fun fetchCovid19(): Single<Covid19Response>

}
