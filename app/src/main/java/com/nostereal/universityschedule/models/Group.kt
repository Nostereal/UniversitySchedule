package com.nostereal.universityschedule.models

import com.google.gson.annotations.SerializedName

data class Group (
    @SerializedName("title")
    val groupName: String,
    val dateFrom: String,
    val dateTo: String,
    val evening: Int,
    val comment: String
)