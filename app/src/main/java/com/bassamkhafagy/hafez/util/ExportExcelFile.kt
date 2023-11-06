package com.bassamkhafagy.hafez.util

import android.content.Context
import android.os.Environment
import com.bassamkhafagy.hafez.data.local.SoraReview
import com.bassamkhafagy.hafez.util.Constant.ReviewExcel.REVIEW_DATE
import com.bassamkhafagy.hafez.util.Constant.ReviewExcel.REVIEW_DEGREE
import com.bassamkhafagy.hafez.util.Constant.ReviewExcel.REVIEW_STATE
import com.bassamkhafagy.hafez.util.Constant.ReviewExcel.REVIEW_STUDENT_CODE
import com.bassamkhafagy.hafez.util.Constant.ReviewExcel.REVIEW_STUDENT_NAME_CODE
import com.bassamkhafagy.hafez.util.Constant.ReviewExcel.REVIEW_STUDENT_RING_CODE
import com.bassamkhafagy.hafez.util.Constant.ReviewExcel.REVIEW_SURAH_TITLE_CODE
import com.bassamkhafagy.hafez.util.Constant.ReviewExcel.REVIEW_Sheikh_CODE
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream

fun exportSoraReviews(reviews: List<SoraReview>, fileName: String) {
    // Create a new workbook
    val workbook = XSSFWorkbook()
    // Create a new sheet
    val sheet = workbook.createSheet("Sora Reviews")
    // Create a header row with the names of the properties
    val headerRow = sheet.createRow(0)
    headerRow.createCell(0).setCellValue("التاريخ")
    headerRow.createCell(1).setCellValue("الكود")
    headerRow.createCell(2).setCellValue("اسم الطالب")
    headerRow.createCell(3).setCellValue("الحلقة")
    headerRow.createCell(4).setCellValue("الشيخ")
    headerRow.createCell(5).setCellValue("السورة")
    headerRow.createCell(6).setCellValue("الحالة")
    headerRow.createCell(7).setCellValue("الدرجة")
    // Loop through the reviews and create a row for each one
    for ((index, review) in reviews.withIndex()) {
        val row = sheet.createRow(index + 1)
        row.createCell(REVIEW_DATE).setCellValue(review.date)
        row.createCell(REVIEW_STUDENT_CODE).setCellValue(review.studentCode)
        row.createCell(REVIEW_STUDENT_NAME_CODE).setCellValue(review.studentName)
        row.createCell(REVIEW_STUDENT_RING_CODE).setCellValue(review.ring)
        row.createCell(REVIEW_Sheikh_CODE).setCellValue(review.sheikhName)
        row.createCell(REVIEW_SURAH_TITLE_CODE).setCellValue(review.soraName)
        row.createCell(REVIEW_STATE).setCellValue(review.state)
        row.createCell(REVIEW_DEGREE).setCellValue(review.degree)
    }
    // Get the document folder path
    val documentFolder =
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
    // Create a new file with the given file name
    val file = File(documentFolder, "$fileName.xlsx")
    // Write the workbook to the file
    val outputStream = FileOutputStream(file)
    workbook.write(outputStream)
    // Close the workbook and the output stream
    outputStream.close()
}