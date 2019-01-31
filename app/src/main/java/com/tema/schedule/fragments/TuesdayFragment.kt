package com.tema.schedule.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tema.schedule.adapters.ScheduleAdapter
import com.tema.schedule.R

class TuesdayFragment : Fragment() {

    private var tuesdaySchedule: MutableList<MutableList<String>> = mutableListOf()

    override fun onStart() {
        super.onStart()
        println("On create")

        val rvTuesday = view?.findViewById<RecyclerView>(R.id.rvTuesday)

        tuesdayScheduleFill()

        rvTuesday?.layoutManager = LinearLayoutManager(this.context)
        rvTuesday?.adapter = ScheduleAdapter(tuesdaySchedule, this.context!!)

    }

    override fun onResume() {
        super.onResume()

        tuesdaySchedule = mutableListOf()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.tue_fragment, container, false)

        tuesdaySchedule = mutableListOf()

        return view
    }



    private fun tuesdayScheduleFill() {
        tuesdaySchedule.add(mutableListOf("9:00 - 10:30", "Пр2306", "История (Лекция)", "Прокопьев Сергей Михайлович"))
        tuesdaySchedule.add(mutableListOf("10:40 - 12:10", "Пр2303", "Физика (Лекция)", "Тронева Мария Александровна"))
        tuesdaySchedule.add(mutableListOf("12:20 - 13:50", "Пр2808", "Математика (Практика)", "Данилов Андрей Николаевич"))
    }
}