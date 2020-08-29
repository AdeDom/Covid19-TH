package com.adedom.covid19_th.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adedom.covid19_th.base.BaseViewModel
import com.adedom.covid19_th.data.model.Covid19Response
import com.adedom.covid19_th.data.repository.DefaultCovid19Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: DefaultCovid19Repository) : BaseViewModel() {

    private val _covid19 = MutableLiveData<Covid19Response>()
    val covid19: LiveData<Covid19Response>
        get() = _covid19

    fun fetchCovid19() {
        launch {
            try {
                val response = repository.fetchCovid19()
                _covid19.value = response
            } catch (e: Throwable) {
                _error.value = e
            }
        }
    }

}
