package com.nostereal.universityschedule.views

interface ScheduleView {
    fun showError(errorText: String)
    fun showSchedule()
    fun openSettings()
    fun openGroupSearchLabel()
    fun closeGroupSearchLabel()
    fun startLoading()
    fun endLoading()
}