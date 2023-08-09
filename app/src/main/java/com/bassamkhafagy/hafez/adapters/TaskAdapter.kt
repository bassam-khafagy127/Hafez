package com.bassamkhafagy.hafez.adapters

import com.bassamkhafagy.hafez.R
import com.bassamkhafagy.hafez.base.BaseAdapter
import com.bassamkhafagy.hafez.data.local.Task


class TaskAdapter<T>(
    mList: List<T>, listener: TaskInterActionListener,
    override val layoutId: Int = R.layout.rv_item_notification
) : BaseAdapter<T>(mList, listener) {


    interface TaskInterActionListener : BaseInterActionListener {
        fun onClickTask(task: Task)
    }
}