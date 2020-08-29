package com.adedom.covid19_th

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel : ViewModel(), CoroutineScope {

    private val job = SupervisorJob()
    private val exceptionHandler = CoroutineExceptionHandler { _, err ->
        _error.value = err
    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main + exceptionHandler

    private val repository = DefaultCovid19Repository()

    private val _covid19 = MutableLiveData<Covid19Response>()
    val covid19: LiveData<Covid19Response>
        get() = _covid19

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable>
        get() = _error

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

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

}
