package com.adedom.covid19_th

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val repository = DefaultCovid19Repository()

    private val _covid19 = MutableLiveData<Covid19Response>()
    val covid19: LiveData<Covid19Response>
        get() = _covid19

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable>
        get() = _error

    fun fetchCovid19() {
        repository.fetchCovid19()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Covid19Response> {
                    override fun onSubscribe(d: Disposable) {
                        compositeDisposable.add(d)
                    }

                    override fun onSuccess(covid19Response: Covid19Response) {
                        _covid19.value = covid19Response
                    }

                    override fun onError(e: Throwable) {
                        _error.value = e
                    }
                })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}
