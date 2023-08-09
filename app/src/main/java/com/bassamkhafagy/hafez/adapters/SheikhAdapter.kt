package com.bassamkhafagy.hafez.adapters

import com.bassamkhafagy.hafez.base.BaseAdapter
import com.bassamkhafagy.hafez.data.local.Sheikh


class SheikhAdapter<T>(
    mList: List<T>, listener: SheikhInterActionListener,
    override val layoutId: Int = 0//R.layout.rv_item_notification
) : BaseAdapter<T>(mList, listener) {


    interface SheikhInterActionListener : BaseInterActionListener {
        fun onClickSheikh(sheikh: Sheikh)
    }
}