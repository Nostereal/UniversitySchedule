package com.nostereal.universityschedule.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.nostereal.universityschedule.fragments.BaseViewPagerFragment

class ScheduleViewPagerAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val list = listOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

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