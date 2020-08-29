package com.adedom.covid19_th;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.covid19().observe(this, covid19Response -> {
            ((TextView) findViewById(R.id.tvUpdateDate)).setText("" + covid19Response.getUpdateDate());
            ((TextView) findViewById(R.id.tvConfirmed)).setText("" + covid19Response.getConfirmed());
            ((TextView) findViewById(R.id.tvNewConfirmed)).setText("" + covid19Response.getNewConfirmed());
        });

        viewModel.error().observe(this, throwable -> {
            Toast.makeText(getBaseContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
        });

        viewModel.fetchCovid19();
    }

}
