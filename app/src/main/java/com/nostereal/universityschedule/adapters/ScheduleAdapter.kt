package com.nostereal.universityschedule.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nostereal.universityschedule.R
import com.nostereal.universityschedule.data.ScheduleResponse
import kotlinx.android.synthetic.main.day_item.view.*

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {
    private val daysList = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Sunday")
    private lateinit var dayAdapter: DayAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        return ScheduleViewHolder(parent)
    }

    override fun getItemCount(): Int = daysList.size

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(daysList[position])
        dayAdapter = DayAdapter()
        holder.initChildRecyclerView(dayAdapter)
    }

    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        constructor(parent: ViewGroup) :
                this(LayoutInflater.from(parent.context).inflate(R.layout.day_item, parent, false))

        fun bind(title: String) {
            itemView.day_title.text = title
        }

        fun initChildRecyclerView(adapter: DayAdapter) {
            itemView.pairs_cards_rv.apply {
                this.adapter = adapter
                layoutManager = LinearLayoutManager(itemView.context)
            }
        }
    }

    fun setDaysItems(data: ScheduleResponse) {

    }
}