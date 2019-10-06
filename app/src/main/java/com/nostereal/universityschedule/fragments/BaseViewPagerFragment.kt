package com.nostereal.universityschedule.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nostereal.universityschedule.R
import com.nostereal.universityschedule.adapters.DayAdapter
import com.nostereal.universityschedule.models.Day
import kotlinx.android.synthetic.main.viewpager_fragment_layout.*

class BaseViewPagerFragment : Fragment() {

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

        tv_day_name_vp1.text = arguments?.getString("day") ?: "OOps, null values in fragment args :("

        val dayAdapter = DayAdapter()
        val currDayId = arguments!!.getInt("dayId")

        rv_pairs_vp1.adapter = dayAdapter
        rv_pairs_vp1.layoutManager = LinearLayoutManager(view.context)
    }
}