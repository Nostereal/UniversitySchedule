package com.nostereal.universityschedule.models

import com.google.gson.annotations.SerializedName

data class ScheduleResponse (
    val status: String,
    @SerializedName("grid")
    val days: Days,
    val group: Group,
    val isSession: Boolean
)