package com.nostereal.universityschedule.models

import com.google.gson.annotations.SerializedName

data class Pair (
    @SerializedName("subject")
    val subjectName: String,
    @SerializedName("teacher")
    val teacherName: String,
    @SerializedName("date_from")
    val dateFrom: String,
    @SerializedName("date_to")
    val dateTo: String,
    val auditories: ArrayList<Auditory>,
    val type: String,
    val week: String,
    @SerializedName("first_module")
    val isFirstModule: Boolean,
    @SerializedName("second_module")
    val isSecondModule: Boolean,
    @SerializedName("no_module")
    val isNoModule: Boolean
)