package com.adedom.covid19_th

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DefaultCovid19Repository {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://covid19.th-stat.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    private val api = retrofit.create(Covid19Api::class.java)

    fun fetchCovid19(): Single<Covid19Response> = api.fetchCovid19()

}
