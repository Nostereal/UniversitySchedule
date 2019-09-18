package com.nostereal.universityschedule.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.nostereal.universityschedule.fragments.BaseViewPagerFragment

class ScheduleViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    private val list = listOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Sunday")
    private val schedule = listOf(
        arrayListOf("0, 0", "0, 1", "0, 2"),
        arrayListOf("1, 0", "1, 1"),
        arrayListOf("2, 0", "2, 1", "2, 2", "2, 3"),
        arrayListOf("3, 0"),
        arrayListOf("4, 0", "4, 1", "4, 2"),
        arrayListOf("5, 0", "5, 1", "5, 2")
    )

    override fun getItem(position: Int): Fragment {
        val frag = BaseViewPagerFragment()

        val bundle = Bundle()
        bundle.putString("day", list[position])
        bundle.putInt("dayId", position)

        frag.arguments = bundle
        return frag
    }

    override fun getCount(): Int = list.size
}