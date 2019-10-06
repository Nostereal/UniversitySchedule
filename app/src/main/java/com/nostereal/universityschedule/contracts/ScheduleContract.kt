package com.nostereal.universityschedule.contracts

import com.nostereal.universityschedule.models.ScheduleResponse
import com.nostereal.universityschedule.network.Result
import kotlinx.coroutines.Deferred

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
    }

    interface Presenter {
        fun loadSchedule(groupName: String, isSession: Boolean = false)
    }

    interface Model {
        fun getScheduleAsync(groupName: String, isSession: Boolean = false): Deferred<Result<ScheduleResponse>>
    }
}