package com.nostereal.universityschedule.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nostereal.universityschedule.R
import kotlinx.android.synthetic.main.day_item.view.*
import kotlinx.android.synthetic.main.item_pair.view.*

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {
    private val list = listOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Sunday")
    private lateinit var dayAdapter: DayAdapter
    private val newSchedule: List<List<String>> = listOf(
        listOf("New0 String 1", "New0 String 2", "New0 String 3", "New0 String 4"),
        listOf("New1 String 1", "New1 String 2", "New1 String 3", "New1 String 4"),
        listOf("New2 String 1", "New2 String 2", "New2 String 3", "New2 String 4"),
        listOf("asdf", "asdf", "asdf", "asdf", "asdf"),
        listOf("aashdf", "a"),
        listOf()
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        return ScheduleViewHolder(parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(list[position])
        dayAdapter = DayAdapter()
        holder.initRecyclerView(dayAdapter)
        dayAdapter.updateSchedule(newSchedule = newSchedule[position])
    }

    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        constructor(parent: ViewGroup) :
                this(LayoutInflater.from(parent.context).inflate(R.layout.day_item, parent, false))

        fun bind(title: String) {
            itemView.day_title.text = title
        }

        fun initRecyclerView(adapter: DayAdapter) {
            itemView.pairs_cards_rv.adapter = adapter
            itemView.pairs_cards_rv.layoutManager = LinearLayoutManager(itemView.context)
        }
    }

}