package com.nostereal.universityschedule.data

import com.google.gson.annotations.SerializedName

data class ScheduleResponse (
    @SerializedName("status")
    val status: String,
    @SerializedName("grid")
    val days: Days,
    @SerializedName("group")
    val group: Group,
    @SerializedName("isSession")
    val isSession: Boolean
)