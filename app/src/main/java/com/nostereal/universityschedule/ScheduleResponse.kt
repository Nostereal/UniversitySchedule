package com.nostereal.universityschedule

import com.google.gson.annotations.SerializedName

data class ScheduleResponse (
    val status: String,
    @SerializedName("grid")
    val days: Days,
    val group: Group,
    val isSession: Boolean
)

data class Group (
    @SerializedName("title")
    val groupName: String,
    val dateFrom: String,
    val dateTo: String,
    val evening: Int,
    val comment: String
)

enum class DayIndices(val id: Int) {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7)
}

// aka 'grid'
data class Days (
    @SerializedName("1")
    val monday: Day,
    @SerializedName("2")
    val tuesday: Day,
    @SerializedName("3")
    val wednesday: Day,
    @SerializedName("4")
    val thursday: Day,
    @SerializedName("5")
    val friday: Day,
    @SerializedName("6")
    val saturday: Day
)

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

data class Auditory (
    @SerializedName("title")
    val name: String,
    @SerializedName("color")
    val textColor: String
)