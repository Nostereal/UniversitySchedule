package com.nostereal.universityschedule.models

import android.content.Context
import com.nostereal.universityschedule.contracts.ScheduleContract
import com.nostereal.universityschedule.data.ScheduleResponse
import com.nostereal.universityschedule.network.Result
import com.nostereal.universityschedule.network.ScheduleApi
import com.nostereal.universityschedule.network.ScheduleService
import kotlinx.coroutines.*

class ScheduleModel : ScheduleContract.Model {

    override suspend fun getScheduleAsync(
        context: Context,
        groupName: String,
        isSession: Boolean
    ): Result<ScheduleResponse> = withContext(Dispatchers.Default) {
        val retrofit = ScheduleService.create(context)
        withContext(Dispatchers.IO) { ScheduleApi(retrofit).getSchedule(groupName, isSession) }
    }
}