package com.nostereal.universityschedule.contracts

import com.nostereal.universityschedule.models.ScheduleResponse
import com.nostereal.universityschedule.network.Result
import kotlinx.coroutines.Deferred

interface ScheduleContract {

    interface View {
        fun initView()
        fun showError(errorText: String)
        fun showSchedule()
        fun openSettings()
        fun openGroupSearchLabel()
        fun closeGroupSearchLabel()
        fun startLoading()
        fun endLoading()
    }

    interface Presenter {
        suspend fun getSchedule(groupName: String, isSession: Boolean = false): ScheduleResponse?
    }

    interface Model {
        fun getScheduleAsync(groupName: String, isSession: Boolean = false): Deferred<Result<ScheduleResponse>>
    }
}