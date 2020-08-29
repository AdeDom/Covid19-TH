package com.adedom.covid19_th.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    private val job = SupervisorJob()
    private val exceptionHandler = CoroutineExceptionHandler { _, err ->
        _error.value = err
    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main + exceptionHandler

    protected val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable>
        get() = _error

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

}
