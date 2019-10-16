package com.nostereal.universityschedule.network

import com.nostereal.universityschedule.data.ScheduleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ScheduleApi(private val scheduleService: ScheduleService) {
    suspend fun getSchedule(
        groupName: String,
        isSession: Boolean = false
    ): Result<ScheduleResponse>  = withContext(Dispatchers.IO) {
        val isSessionInt: Int = if (isSession) 1 else 0
        val response = scheduleService.getSchedule(groupName, isSessionInt)

        try {
            if (response.status == "ok") {
                Result.Success(response)
            } else {
                Result.Failure("Response status is not `ok`")
            }
        } catch (e: Exception) {
            Result.Failure("An exception was caught", e)
        }
    }
}