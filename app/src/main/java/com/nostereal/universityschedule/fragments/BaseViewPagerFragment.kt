package com.nostereal.universityschedule.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nostereal.universityschedule.R
import com.nostereal.universityschedule.adapters.DayAdapter
import com.nostereal.universityschedule.adapters.ScheduleAdapter
import kotlinx.android.synthetic.main.viewpager_fragment_layout.*

class BaseViewPagerFragment : Fragment() {
    private val schedule = listOf(
        arrayListOf("0, 0", "0, 1", "0, 2"),
        arrayListOf("1, 0", "1, 1"),
        arrayListOf("2, 0", "2, 1", "2, 2", "2, 3"),
        arrayListOf("3, 0"),
        arrayListOf("4, 0", "4, 1", "4, 2"),
        arrayListOf("5, 0", "5, 1", "5, 2")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.viewpager_fragment_layout, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        day_name_vp1.text = arguments?.getString("day") ?: "OOps, null values :("

        val dayAdapter = DayAdapter()
        val currDayId = arguments!!.getInt("dayId")
        dayAdapter.updateSchedule(schedule[currDayId])

        pairs_rv_vp1.adapter = dayAdapter
        pairs_rv_vp1.layoutManager = LinearLayoutManager(view.context)

    }
}