package com.nostereal.universityschedule.contracts

import android.content.Context
import com.nostereal.universityschedule.data.ScheduleResponse
import com.nostereal.universityschedule.network.Result

interface ScheduleContract {

    interface View {
        fun initView()
        fun showError(errorText: String)
        fun showSchedule(schedule: ScheduleResponse)
        fun openSettings()
        fun openGroupSearchLabel()
        fun closeGroupSearchLabel()
        fun startLoading()
        fun endLoading()
        val context: Context
    }

    interface Presenter {
        fun loadSchedule(groupName: String, isSession: Boolean = false)
        fun onDestroy()
    }

    interface Model {
        suspend fun getScheduleAsync(context: Context, groupName: String, isSession: Boolean = false): Result<ScheduleResponse>
    }
}