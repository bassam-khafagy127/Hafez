package com.bassamkhafagy.hafez.util

import android.content.Context
import com.bassamkhafagy.hafez.data.local.SoraReview
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File

fun exportToExcel(reviewList: List<SoraReview>, context:Context, authName:String) {
    val fileName = "review_data.xlsx"
    val storageDir = context.getExternalFilesDir(null)
    val filePath = File(storageDir, fileName).absolutePath

    val workbook = XSSFWorkbook()
    val sheet = workbook.createSheet("Review Data")

}