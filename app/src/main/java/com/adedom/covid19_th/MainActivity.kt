package com.adedom.covid19_th

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.covid19.observe(this, { covid19Response ->
            tvUpdateDate.text = "" + covid19Response.updateDate
            tvConfirmed.text = "" + covid19Response.confirmed
            tvNewConfirmed.text = "" + covid19Response.newConfirmed
        })

        viewModel.error.observe(this, { throwable ->
            Toast.makeText(baseContext, throwable.message, Toast.LENGTH_LONG).show()
        })

        viewModel.fetchCovid19()
    }

}
