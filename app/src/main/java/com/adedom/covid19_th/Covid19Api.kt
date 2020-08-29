package com.adedom.covid19_th;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface Covid19Api {

    @GET("/api/open/today")
    Single<Covid19Response> fetchCovid19();

}
