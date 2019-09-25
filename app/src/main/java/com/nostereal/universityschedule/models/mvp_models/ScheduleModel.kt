package com.nostereal.universityschedule.models.mvp_models

import com.nostereal.universityschedule.contracts.ScheduleContract
import com.nostereal.universityschedule.models.ScheduleResponse
import com.nostereal.universityschedule.network.Result
import com.nostereal.universityschedule.network.ScheduleApi
import com.nostereal.universityschedule.network.ScheduleService
import kotlinx.coroutines.*

class ScheduleModel : ScheduleContract.Model {

    override fun getScheduleAsync(groupName: String, isSession: Boolean): Deferred<Result<ScheduleResponse>> {
        val retrofit = ScheduleService.create()

        val deferred = CoroutineScope(Dispatchers.IO).async {
            return@async ScheduleApi(retrofit).getSchedule(groupName, isSession)
        }

        return deferred
    }
}