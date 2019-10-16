package com.nostereal.universityschedule.presenters

import com.nostereal.universityschedule.contracts.ScheduleContract
import com.nostereal.universityschedule.data.ScheduleResponse
import com.nostereal.universityschedule.data.local.ScheduleRepository
import com.nostereal.universityschedule.network.Result
import com.nostereal.universityschedule.utils.DispatcherProvider
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SchedulePresenter(
    _view: ScheduleContract.View,
    private val dispatcher: DispatcherProvider
) : ScheduleContract.Presenter, CoroutineScope {

    private val jobTracker: Job = SupervisorJob()
    private val mainScope = CoroutineScope(coroutineContext)

    private var view: ScheduleContract.View = _view

    private val repository = ScheduleRepository()
    private val blockedGroups: ArrayList<String> = arrayListOf("3ТпупБ-5-1,3ТпупБД-5-1")

    init {
        view.initView()
    }

    override fun loadSchedule(groupName: String, isSession: Boolean) {
        mainScope.launch {
            view.startLoading()

            val result: Result<ScheduleResponse> = withContext(Dispatchers.IO) {
                if (groupName !in blockedGroups) {
                    // invoke getSchedule on the repository method
                    // which will choose type of connection: either cache or GET request
                    repository.getSchedule(view.context, groupName, isSession)
                } else {
                    Result.Failure("Are you f*cking kidding me??!!?")
                }
            }

            view.endLoading()
            when (result) {
                is Result.Success -> view.showSchedule(result.data)
                is Result.Failure -> view.showError(result.message)
            }
        }
    }

    override fun onDestroy() {
        jobTracker.cancelChildren()
    }

    override val coroutineContext: CoroutineContext
        get() = dispatcher.provideUIContext() + jobTracker
}
