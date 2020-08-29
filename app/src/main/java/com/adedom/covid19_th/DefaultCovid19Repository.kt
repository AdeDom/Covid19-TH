package com.adedom.covid19_th

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DefaultCovid19Repository {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://covid19.th-stat.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val api = retrofit.create(Covid19Api::class.java)

    suspend fun fetchCovid19(): Covid19Response = api.fetchCovid19()

}
