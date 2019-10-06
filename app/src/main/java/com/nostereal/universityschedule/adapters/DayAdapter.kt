package com.nostereal.universityschedule.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nostereal.universityschedule.DiffUtilCallback
import com.nostereal.universityschedule.R
import com.nostereal.universityschedule.models.Day
import com.nostereal.universityschedule.models.Pair
import kotlinx.android.synthetic.main.item_pair.view.*

class DayAdapter : RecyclerView.Adapter<DayAdapter.DayViewHolder>() {

    private var scheduleList: List<Day> = listOf()
    private lateinit var pairsPerTimeAdapter: PairsPerTimeAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        return DayViewHolder(parent)
    }

    override fun getItemCount(): Int = scheduleList.size

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.bind(scheduleList[position])
        pairsPerTimeAdapter = PairsPerTimeAdapter()
        holder.initChildRecyclerView(pairsPerTimeAdapter)
    }

    class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        constructor(parent: ViewGroup) :
                this(LayoutInflater.from(parent.context).inflate(R.layout.item_pair, parent, false))

        fun bind(day: Day) {
            val pairs = splitDayToPairs(day)

            itemView.apply {
                TODO("attach pairs info")
            }
        }

        private fun splitDayToPairs(day: Day): List<ArrayList<Pair>> {
            val (firstPair, secondPair, thirdPair, fourthPair, fifthPair, sixthPair, seventhPair) = day
            return mutableListOf(
                firstPair,
                secondPair,
                thirdPair,
                fourthPair,
                fifthPair,
                sixthPair,
                seventhPair
            )
        }

        fun initChildRecyclerView(adapter: PairsPerTimeAdapter) {
            itemView.rv_pairs.apply {
                rv_pairs.adapter = adapter
                rv_pairs.layoutManager = LinearLayoutManager(itemView.context)
            }
        }
    }

    fun updateSchedule(newSchedule: ArrayList<Day>) {
        val diffUtilCallback = DiffUtilCallback(scheduleList, newSchedule)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)

        scheduleList = mutableListOf<Day>().apply { addAll(newSchedule) }
        diffResult.dispatchUpdatesTo(this)
    }
}