package com.adedom.covid19_th.ui

import android.os.Bundle
import com.adedom.covid19_th.R
import com.adedom.covid19_th.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.covid19.observe { covid19Response ->
            tvUpdateDate.text = "" + covid19Response.updateDate
            tvConfirmed.text = "" + covid19Response.confirmed
            tvNewConfirmed.text = "" + covid19Response.newConfirmed
        }

        viewModel.error.observeError()

        viewModel.fetchCovid19()
    }

}
