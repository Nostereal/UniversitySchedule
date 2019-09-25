package com.nostereal.universityschedule.network

import com.nostereal.universityschedule.models.ScheduleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ScheduleApi(private val scheduleService: ScheduleService) {
    suspend fun getCookieScript(groupName: String, isSession: Boolean = false): Result<String> = withContext(Dispatchers.IO) {
        val isSessionInt: Int = if (isSession) 1 else 0

        val request = scheduleService.getCookieScript(groupName, isSessionInt)

        try {
            val response = request.await()
            if (response.isNotEmpty()) {
                val cookie = parseCookie(response)
                Result.Success(cookie)
            } else {
                Result.Failure("Response is empty")
            }
        } catch (e: Exception) {
            Result.Failure("An exception was caught", e)
        }
    }

    suspend fun getSchedule(
        groupName: String,
        isSession: Boolean = false,
        parsedCookie: String = ""
    ): Result<ScheduleResponse>  = withContext(Dispatchers.IO) {
        val isSessionInt: Int = if (isSession) 1 else 0

        val request = scheduleService.getSchedule(groupName, isSessionInt)

        try {
            val response = request.await()
            if (response.status.equals("ok")) {
                Result.Success(response)
            } else {
                Result.Failure("Response status is not `ok`")
            }
        } catch (e: Exception) {
            Result.Failure("An exception was caught", e)
        }
    }

    private fun parseCookie(str: String): String {
        return str
    }
}