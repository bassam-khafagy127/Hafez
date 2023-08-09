package com.bassamkhafagy.hafez.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun getSystemDate(): String {
    val currentDate = Calendar.getInstance().time
    val dateFormat =
        SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
    return dateFormat.format(
        currentDate
    )

}
