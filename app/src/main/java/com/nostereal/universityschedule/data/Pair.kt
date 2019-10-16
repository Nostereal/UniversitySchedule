package com.nostereal.universityschedule.data

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
    @SerializedName("auditories")
    val auditories: ArrayList<Auditory>,
    @SerializedName("type")
    val type: String,
//    val week: String,
    @SerializedName("first_module")
    val isFirstModule: Boolean,
    @SerializedName("second_module")
    val isSecondModule: Boolean,
    @SerializedName("no_module")
    val isNoModule: Boolean
)