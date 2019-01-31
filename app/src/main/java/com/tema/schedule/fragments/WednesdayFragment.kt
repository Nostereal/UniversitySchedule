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

class WednesdayFragment : Fragment() {

    private var wednesdaySchedule: MutableList<MutableList<String>> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.wed_fragment, container, false)

        wednesdaySchedule = mutableListOf()

        return view
    }

    override fun onResume() {
        super.onResume()

        wednesdaySchedule = mutableListOf()
    }

    override fun onStart() {
        super.onStart()

        val rvWednesday = view?.findViewById<RecyclerView>(R.id.rvWednesday)

        wednesdayScheduleFill()

        rvWednesday?.layoutManager = LinearLayoutManager(this.context)
        rvWednesday?.adapter = ScheduleAdapter(wednesdaySchedule, this.context!!)
    }

    private fun wednesdayScheduleFill() {
        wednesdaySchedule.add(mutableListOf("9:00 - 10:30", "МСпорт. Зал", "Элективные курсы по физической культуре и спорту (Практика)", ""))
        wednesdaySchedule.add(mutableListOf("10:40 - 12:10", "Пр2306", "Информатика (Лекция)", "Рудяк Юрий Владимирович"))
        wednesdaySchedule.add(mutableListOf("12:20 - 13:50", "Пр2306", "Инновационное материаловедение в информационных системах (Лекция)", "Зеленская Марина Викторовна"))
    }
}