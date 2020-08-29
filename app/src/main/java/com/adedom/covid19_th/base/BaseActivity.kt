package com.adedom.covid19_th.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import com.adedom.covid19_th.extension.toast

abstract class BaseActivity : AppCompatActivity() {

    protected inline fun <reified T> LiveData<T>.observe(crossinline onNext: (T) -> Unit) {
        observe(this@BaseActivity, { onNext(it) })
    }

    protected fun LiveData<Throwable>.observeError() {
        observe(this@BaseActivity, { throwable ->
            throwable.printStackTrace()
            toast(throwable.message)
        })
    }

}
