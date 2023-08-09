package com.bassamkhafagy.hafez.adapters

import com.bassamkhafagy.hafez.base.BaseAdapter
import com.bassamkhafagy.hafez.data.local.Students


class StudentsAdapter<T>(
    mList: List<T>, listener: StudentsInterActionListener,
    override val layoutId: Int = 0//R.layout.rv_item_notification
) : BaseAdapter<T>(mList, listener) {


    interface StudentsInterActionListener : BaseInterActionListener {
        fun onClickStudents(student: Students)
    }
}