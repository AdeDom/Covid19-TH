package com.adedom.covid19_th.ui.timeline

import android.view.View
import com.adedom.covid19_th.R
import com.adedom.covid19_th.base.BaseRecyclerView
import com.adedom.covid19_th.data.model.TimelineData
import kotlinx.android.synthetic.main.item_timeline.view.*

class TimelineAdapter : BaseRecyclerView<TimelineData>() {

    override fun getLayout(): Int = R.layout.item_timeline

    override fun View.onBindViewHolder(data: TimelineData) {
        tvDate.text = data.date
        tvNewConfirmed.text = data.newConfirmed.toString()
    }

}
