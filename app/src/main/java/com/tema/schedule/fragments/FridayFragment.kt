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

class FridayFragment : Fragment() {

    private var fridaySchedule: MutableList<MutableList<String>> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fri_fragment, container, false)

        fridaySchedule = mutableListOf()

        return view
    }

    override fun onResume() {
        super.onResume()

        fridaySchedule = mutableListOf()
    }

    override fun onStart() {
        super.onStart()

        val rvFriday = view?.findViewById<RecyclerView>(R.id.rvFriday)

        fridayScheduleFill()

        rvFriday?.layoutManager = LinearLayoutManager(this.context)
        rvFriday?.adapter = ScheduleAdapter(fridaySchedule, this.context!!)
    }

    private fun fridayScheduleFill() {
        fridaySchedule.add(mutableListOf("9:00 - 10:30", "Пр2662", "Объектно-ориентированное программирование (Лаб.работа)", "Шурыгин Владимир Николаевич,\nАлпатова Марианна Валерьевна"))
        fridaySchedule.add(mutableListOf("10:40 - 12:10", "Пр2303", "Математика (Лекция)", "Норин Владимир Павлович"))
        fridaySchedule.add(mutableListOf("12:20 - 13:50", "Пр2808", "Деловая этика (Практика)", "Отц Екатерина Викторовна"))
        fridaySchedule.add(mutableListOf("14:30 - 16:00", "Пр2558\tПр2559", "Информатика (Лаб. работа)", "Рудяк Юрий Владимирович, Меньшикова Наталия Павловна"))
    }
}