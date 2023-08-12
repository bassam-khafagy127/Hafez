package com.bassamkhafagy.hafez.util

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import com.bassamkhafagy.hafez.R

fun showSuccessToast(context: Context) {
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val layout = inflater.inflate(R.layout.insert_review_toast_layout, null)

    val toast = Toast(context)
    toast.duration = Toast.LENGTH_SHORT
    toast.setGravity(Gravity.CENTER, 0, 0)
    toast.view = layout
    toast.show()
}

fun showImportDataSuccessToast(context: Context) {
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val layout = inflater.inflate(R.layout.import_data_toast_layout, null)
    val toast = Toast(context)
    toast.duration = Toast.LENGTH_SHORT
    toast.setGravity(Gravity.CENTER, 0, 0)
    toast.view = layout
    toast.show()
}

fun showExportDataSuccessToast(context: Context) {
    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val layout = inflater.inflate(R.layout.export_data_toast_layout, null)
    val toast = Toast(context)
    toast.duration = Toast.LENGTH_SHORT
    toast.setGravity(Gravity.CENTER, 0, 0)
    toast.view = layout
    toast.show()
}