package com.nostereal.universityschedule.data

import com.google.gson.annotations.SerializedName

data class Day (
    @SerializedName("1")
    val firstPair: ArrayList<Pair>,
    @SerializedName("2")
    val secondPair: ArrayList<Pair>,
    @SerializedName("3")
    val thirdPair: ArrayList<Pair>,
    @SerializedName("4")
    val fourthPair: ArrayList<Pair>,
    @SerializedName("5")
    val fifthPair: ArrayList<Pair>,
    @SerializedName("6")
    val sixthPair: ArrayList<Pair>,
    @SerializedName("7")
    val seventhPair: ArrayList<Pair>
)
