package com.nostereal.universityschedule.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.nostereal.universityschedule.R
import kotlinx.android.synthetic.main.item_pair.view.*

class DayAdapter : RecyclerView.Adapter<DayAdapter.DayViewHolder>() {
    private var scheduleList = listOf("String 1", "String 2", "String 3")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        return DayViewHolder(parent)
    }

    override fun getItemCount(): Int = scheduleList.size

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.bind(scheduleList[position])
    }

    class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        constructor(parent: ViewGroup) :
                this(LayoutInflater.from(parent.context).inflate(R.layout.item_pair, parent, false))

        fun bind(title: String) {
            itemView.textView.text = title
        }

    }

    fun updateSchedule(newSchedule: List<String>) {
        scheduleList = newSchedule
        notifyDataSetChanged()
    }
}