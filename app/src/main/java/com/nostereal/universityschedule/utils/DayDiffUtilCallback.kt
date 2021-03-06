package com.nostereal.universityschedule.utils

import androidx.recyclerview.widget.DiffUtil
import com.nostereal.universityschedule.data.Day

class DayDiffUtilCallback(
    private val oldList: List<Day>,
    private val newList: List<Day>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemPosition == newItemPosition
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}