package com.bassamkhafagy.hafez.util

import android.util.Log
import com.bassamkhafagy.hafez.data.local.Sheikh
import com.bassamkhafagy.hafez.data.local.Students
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.InputStream

fun parseImportedStudentsExcelFile(inputStream: InputStream): List<Students> {
    val dataList = mutableListOf<Students>()
    val workbook = XSSFWorkbook(inputStream)
    val sheet = workbook.getSheetAt(0) // Assuming data is in the first sheet

    for (rowIndex in sheet.firstRowNum + 1 until sheet.lastRowNum + 1) {
        val row = sheet.getRow(rowIndex)

        val studentCode = row.getCell(Constant.StudentExcel.STUDENT_CODE).numericCellValue.toInt()

        val studentName =
            row.getCell(Constant.StudentExcel.STUDENT_NAME_CODE).stringCellValue

        val startDate = row.getCell(Constant.StudentExcel.STUDENT_START_DATE_CODE).stringCellValue


        val ring = row.getCell(Constant.StudentExcel.STUDENT_RING_CODE).stringCellValue

        val payState = row.getCell(Constant.StudentExcel.STUDENT_PAYING_STATE_CODE).stringCellValue

        Log.d("Excelll", payState)

        dataList.add(
            Students(
                studentCode,
                studentName,
                startDate,
                ring,
                payState,
                null,
                null
            )
        )
    }

    return dataList
}

fun parseImportedSheikhExcelFile(inputStream: InputStream): List<Sheikh> {
    val dataList = mutableListOf<Sheikh>()
    val workbook = XSSFWorkbook(inputStream)
    val sheet = workbook.getSheetAt(0) // Assuming data is in the first sheet

    for (rowIndex in sheet.firstRowNum + 1 until sheet.lastRowNum + 1) {
        val row = sheet.getRow(rowIndex)

        val sheikhName =
            row.getCell(Constant.SheikhExcel.SHEIKH_NAME).stringCellValue

        val hisRing =
            row.getCell(Constant.SheikhExcel.SHEIKH_PER_RING).stringCellValue

        val ring = row.getCell(Constant.SheikhExcel.SHEIKH_RING).stringCellValue

        Log.d("Excelll", ring)

        dataList.add(
            Sheikh(
                0,
                sheikhName,
                hisRing,
                ring
            )
        )
    }

    return dataList
}