package com.nostereal.universityschedule.data

import com.google.gson.annotations.SerializedName

data class Group (
    @SerializedName("title")
    val groupName: String,
    @SerializedName("dateFrom")
    val dateFrom: String,
    @SerializedName("dateTo")
    val dateTo: String,
    @SerializedName("evening")
    val evening: Int,
    @SerializedName("comment")
    val comment: String
)