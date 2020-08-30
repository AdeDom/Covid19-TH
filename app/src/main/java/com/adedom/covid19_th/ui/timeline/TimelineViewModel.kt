package com.adedom.covid19_th.ui.timeline

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adedom.covid19_th.base.BaseViewModel
import com.adedom.covid19_th.data.response.TimelineResponse
import com.adedom.covid19_th.data.repository.DefaultCovid19Repository
import kotlinx.coroutines.launch

class TimelineViewModel(private val repository: DefaultCovid19Repository) : BaseViewModel() {

    private val _timeline = MutableLiveData<TimelineResponse>()
    val timeline: LiveData<TimelineResponse>
        get() = _timeline

    fun fetchTimeline() {
        launch {
            try {
                val response = repository.fetchTimeline()
                _timeline.value = response
            } catch (e: Throwable) {
                _error.value = e
            }
        }
    }

}
