package com.nostereal.universityschedule.presenters

import com.nostereal.universityschedule.contracts.ScheduleContract
import com.nostereal.universityschedule.models.ScheduleResponse
import com.nostereal.universityschedule.models.mvp_models.ScheduleModel
import com.nostereal.universityschedule.network.Result
import kotlinx.coroutines.*

class SchedulePresenter(_view: ScheduleContract.View) : ScheduleContract.Presenter {

    private var view: ScheduleContract.View = _view
    private val model: ScheduleModel = ScheduleModel()

    private val blockedGroups: ArrayList<String> = arrayListOf("3ТпупБ-5-1,3ТпупБД-5-1")

    init {
        view.initView()
    }

    override fun loadSchedule(groupName: String, isSession: Boolean) {
        GlobalScope.launch(Dispatchers.Default) {
            view.startLoading()

            val deferred: Deferred<Result<ScheduleResponse>>
            val result: Result<ScheduleResponse>

            if (groupName !in blockedGroups) {
                deferred = model.getScheduleAsync(groupName, isSession)
                result = deferred.await()
            } else {
                result = Result.Failure("Are you f*cking kidding me??!!?")
            }

            launch(Dispatchers.Main) {
                when (result) {
                    is Result.Success -> {
                        view.endLoading()
                        view.showSchedule(result.data)
                    }
                    is Result.Failure -> {
                        view.endLoading()
                        view.showError(result.message)
                    }
                }
            }
        }
    }
}