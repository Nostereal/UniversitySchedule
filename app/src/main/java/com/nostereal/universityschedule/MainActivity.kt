package com.nostereal.universityschedule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nostereal.universityschedule.adapters.ScheduleAdapter
import kotlinx.android.synthetic.main.viewpager_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = ScheduleAdapter()

//        bottom_app_bar.setOnMenuItemClickListener { item ->
//            when (item.itemId) {
//                R.id.app_bar_settings -> TODO("create the settings activity / window")
//                R.id.app_bar_group_search -> TODO("perform a request to the server")
//            }
//
//            true
//        }
//
//        val currGroup = bottom_app_bar.menu.findItem(R.id.app_bar_curr_group)
//        currGroup.setOnMenuItemClickListener {
//            TODO("open the search area and process the request")
//            // it.title = "181-722"
//
//            true
//        }
    }
}
