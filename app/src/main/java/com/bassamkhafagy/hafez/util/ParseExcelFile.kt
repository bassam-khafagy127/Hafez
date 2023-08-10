package com.bassamkhafagy.hafez.util

import android.util.Log
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

        //        val phoneNumber =
        //            row.getCell(Constant.StudentExcel.STUDENT_PHONE_NUMBER_CODE).stringCellValue

        //   val birthDate = row.getCell(Constant.StudentExcel.STUDENT_BIRTH_DATE_CODE).dateCellValue.toString()

        Log.d("Excelll", studentCode.toString())

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