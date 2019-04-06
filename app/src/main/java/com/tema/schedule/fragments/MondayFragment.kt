package com.tema.schedule.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tema.schedule.R
import com.tema.schedule.adapters.ScheduleAdapter


class MondayFragment : Fragment() {

    private var mondaySchedule: MutableList<MutableList<String>> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.mon_fragment, container, false)

        mondaySchedule = mutableListOf()

        return view
    }

    override fun onResume() {
        super.onResume()

        mondaySchedule = mutableListOf()
    }

    override fun onStart() {
        super.onStart()

        val rvMonday = view?.findViewById<RecyclerView>(R.id.rvMonday)

        mondayScheduleFill()

        rvMonday?.layoutManager = LinearLayoutManager(this.context)
        rvMonday?.adapter = ScheduleAdapter(mondaySchedule, this.context!!)



    }

    private fun mondayScheduleFill() {
        mondaySchedule.add(mutableListOf("9:00 - 10:30", "МСпорт.Зал", "Физическая культура и спорт (Практика)", ""))
        mondaySchedule.add(mutableListOf("10:40 - 12:10",
            "Пр2553 Пр2662",
            "Объектно-ориентированное программирование (Лаб. работа)",
            "Арсентьев Дмитрий Андреевич,\nАлпатова Марианна Валерьевна"))
    }
}