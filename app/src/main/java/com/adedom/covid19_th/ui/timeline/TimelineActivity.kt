package com.adedom.covid19_th.ui.timeline

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adedom.covid19_th.R
import com.adedom.covid19_th.base.BaseActivity
import kotlinx.android.synthetic.main.activity_timeline.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TimelineActivity : BaseActivity() {

    private val viewModel by viewModel<TimelineViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timeline)

        val adt = TimelineAdapter()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(baseContext)
            adapter = adt
        }

        viewModel.timeline.observe { timelineResponse ->
            tvUpdateDate.text = timelineResponse.updateDate
            adt.setList(timelineResponse.data)
        }

        viewModel.error.observeError()

        viewModel.fetchTimeline()
    }

}
