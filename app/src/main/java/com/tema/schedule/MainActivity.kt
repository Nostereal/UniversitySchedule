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
        mViewPager.currentItem = when(getDayOfWeek()) {
            "Tue" -> 1
            "Wed" -> 2
            "Thu" -> 3
            "Fri" -> 4
            else -> 0
        }
    }

    override fun onResume() {
        super.onResume()

        //set item on start
        mViewPager.currentItem = when(getDayOfWeek()) {
            "Tue" -> 1
            "Wed" -> 2
            "Thu" -> 3
            "Fri" -> 4
            else -> 0
        }
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter: SectionPageAdapter =
            SectionPageAdapter(supportFragmentManager)
        adapter.addFragment(MondayFragment(), "Mon")
        adapter.addFragment(TuesdayFragment(), "Tue")
        adapter.addFragment(WednesdayFragment(), "Wed")
        adapter.addFragment(ThursdayFragment(), "Thu")
        adapter.addFragment(FridayFragment(), "Fri")
        viewPager.adapter = adapter
    }

    private fun getDayOfWeek(): String {
        // Detect day of week
        calendar.time = Date()
        val simpleDF = SimpleDateFormat("E") //Format: "Mon"

        return simpleDF.format(calendar.time)
    }



}
