package com.nostereal.universityschedule.data.local

import android.content.Context
import com.nostereal.universityschedule.data.ScheduleResponse
import com.nostereal.universityschedule.models.ScheduleModel
import com.nostereal.universityschedule.network.Result

class ScheduleRepository {
    suspend fun getSchedule(
        context: Context,
        groupName: String,
        isSession: Boolean
    ): Result<ScheduleResponse> = ScheduleModel().getScheduleAsync(context, groupName, isSession)
}