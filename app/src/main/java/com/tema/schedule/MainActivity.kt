package com.tema.schedule

import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity

import android.support.v4.view.ViewPager
import android.os.Bundle
import com.tema.schedule.adapters.SectionPageAdapter
import com.tema.schedule.fragments.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mSectionPageAdapter: SectionPageAdapter
    private lateinit var mViewPager: ViewPager

    private var calendar: Calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSectionPageAdapter = SectionPageAdapter(supportFragmentManager)

        mViewPager = findViewById<ViewPager>(R.id.container)
        setupViewPager(mViewPager)

        val tabLayout: TabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setupWithViewPager(mViewPager)

        //set item on start
        setupDayFragment()
    }

    override fun onResume() {
        super.onResume()
        //set item on resume
        setupDayFragment()
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = SectionPageAdapter(supportFragmentManager)
        with(adapter) {
            addFragment(MondayFragment(), "Mon")
            addFragment(TuesdayFragment(), "Tue")
            addFragment(WednesdayFragment(), "Wed")
            addFragment(ThursdayFragment(), "Thu")
            addFragment(FridayFragment(), "Fri")
        }
        viewPager.adapter = adapter
    }

    private fun setupDayFragment() {
        // Detect day of week
        calendar.time = Date()
        val simpleDF = SimpleDateFormat("E") //Format: "Mon"
        val day = simpleDF.format(calendar.time)

        //set item on start/resume
        mViewPager.currentItem = when(day) {
            "Tue" -> 1
            "Wed" -> 2
            "Thu" -> 3
            "Fri" -> 4
            else -> 0
        }
    }



}
