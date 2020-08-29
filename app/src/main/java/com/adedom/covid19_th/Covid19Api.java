package com.adedom.covid19_th;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Covid19Api {

    @GET("/api/open/today")
    Call<Covid19Response> fetchCovid19();

}
