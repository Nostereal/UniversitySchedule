package com.tema.schedule.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tema.schedule.adapters.ScheduleAdapter
import com.tema.schedule.R

class ThursdayFragment : Fragment() {

    private var thursdaySchedule: MutableList<MutableList<String>> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.thu_fragment, container, false)

        thursdaySchedule = mutableListOf()

        return view
    }

    override fun onResume() {
        super.onResume()

        thursdaySchedule = mutableListOf()
    }

    override fun onStart() {
        super.onStart()

        val rvThursday = view?.findViewById<RecyclerView>(R.id.rvThursday)

        thursdayScheduleFill()

        rvThursday?.layoutManager = LinearLayoutManager(this.context)
        rvThursday?.adapter = ScheduleAdapter(thursdaySchedule, this.context!!)
    }

    private fun thursdayScheduleFill() {
        thursdaySchedule.add(mutableListOf("10:40 - 12:10", "Пр2306", "Физика (Лекция)", "Тронева Мария Александровна"))
        thursdaySchedule.add(mutableListOf("12:20 - 13:50", "Пр2306",
            "Объектно-ориентированное программирование (Лекция)", "Шурыгин Владимир Николаевич"))
        thursdaySchedule.add(mutableListOf("14:30 - 16:00", "Пр2554 Пр2559",
            "Информатика (Лаб. работа)", "Меньшикова Наталия Павловна,\nРудяк Юрий Владимирович"))
    }
}