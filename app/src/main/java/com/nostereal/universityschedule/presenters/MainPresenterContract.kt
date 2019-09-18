package com.nostereal.universityschedule.presenters

import com.nostereal.universityschedule.views.BaseView

interface MainPresenterContract {
    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun onBottomBarSettingsTapped()
        fun onBottomBarSearchTapped()
    }

    interface View : BaseView<Presenter> {
//        fun displaySchedule(schedule: Schedule)
    }
}