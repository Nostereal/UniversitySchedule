package com.nostereal.universityschedule.views

interface BaseView<T> {
    fun setPresenter(presenter: T)
}