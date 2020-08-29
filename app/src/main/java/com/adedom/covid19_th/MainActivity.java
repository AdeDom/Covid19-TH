package com.adedom.covid19_th;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covid19.th-stat.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Covid19Api api = retrofit.create(Covid19Api.class);

        api.fetchCovid19().enqueue(new Callback<Covid19Response>() {

            @Override
            public void onResponse(Call<Covid19Response> call, Response<Covid19Response> response) {
                ((TextView) findViewById(R.id.tvUpdateDate)).setText("" + response.body().getUpdateDate());
                ((TextView) findViewById(R.id.tvConfirmed)).setText("" + response.body().getConfirmed());
                ((TextView) findViewById(R.id.tvNewConfirmed)).setText("" + response.body().getNewConfirmed());
            }

            @Override
            public void onFailure(Call<Covid19Response> call, Throwable t) {
            }

        });
    }

}
