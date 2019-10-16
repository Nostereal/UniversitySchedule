package com.nostereal.universityschedule.data

import com.google.gson.annotations.SerializedName

data class Auditory (
    @SerializedName("title")
    val name: String,
    @SerializedName("color")
    val textColor: String
)