package com.adedom.covid19_th;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DefaultCovid19Repository {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://covid19.th-stat.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    private Covid19Api api = retrofit.create(Covid19Api.class);

    Single<Covid19Response> fetchCovid19() {
        return api.fetchCovid19();
    }

}
