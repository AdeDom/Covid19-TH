package com.adedom.covid19_th

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single<Retrofit> {
        Retrofit.Builder()
                .baseUrl("https://covid19.th-stat.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    single<Covid19Api> { get<Retrofit>().create(Covid19Api::class.java) }

    single<DefaultCovid19Repository> { DefaultCovid19RepositoryImpl(get()) }

    viewModel { MainViewModel(get()) }

}
