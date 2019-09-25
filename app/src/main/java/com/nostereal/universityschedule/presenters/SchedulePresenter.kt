package com.nostereal.universityschedule.presenters

import com.nostereal.universityschedule.contracts.ScheduleContract
import com.nostereal.universityschedule.models.ScheduleResponse
import com.nostereal.universityschedule.models.mvp_models.ScheduleModel
import com.nostereal.universityschedule.network.Result
import kotlinx.coroutines.Deferred

class SchedulePresenter(_view: ScheduleContract.View) : ScheduleContract.Presenter {

    private var view: ScheduleContract.View = _view
    private val model: ScheduleModel = ScheduleModel()

    private val blockedGroups: ArrayList<String> = arrayListOf("3ТпупБ-5-1,3ЕпупБД-5-1")

    init {
        view.initView()
    }

    override suspend fun getSchedule(groupName: String, isSession: Boolean): ScheduleResponse? {
        val deferred: Deferred<Result<ScheduleResponse>>
        val result: Result<ScheduleResponse>
        if (groupName !in blockedGroups) {
            deferred = model.getScheduleAsync(groupName, isSession)
            result = deferred.await()
        } else {
            result = Result.Failure("Are you f*cking kidding me??!!?")
        }

        return when (result) {
            is Result.Success -> result.data
            is Result.Failure -> {
                view.showError(result.message)
                null
            }
        }
    }
}