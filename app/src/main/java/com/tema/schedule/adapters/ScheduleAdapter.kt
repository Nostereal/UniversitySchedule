package com.tema.schedule.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tema.schedule.R
import kotlinx.android.synthetic.main.schedule_item.view.*

class ScheduleAdapter(val items: MutableList<MutableList<String>>, val context: Context) : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.schedule_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.timeTV?.text = items[position][0]
        holder.lectureHallTV?.text = items[position][1]
        holder.subjectTV?.text = items[position][2]
        if (items[position][3] == "")
            holder.teacherNameTV?.height = 0
        else
            holder.teacherNameTV?.text = items[position][3]
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val timeTV : TextView? = view.timeTextView
        val lectureHallTV : TextView? = view.lectureHallTextView
        val subjectTV: TextView? = view.subjectTextView
        val teacherNameTV: TextView? = view.teacherNameTextView
    }
}