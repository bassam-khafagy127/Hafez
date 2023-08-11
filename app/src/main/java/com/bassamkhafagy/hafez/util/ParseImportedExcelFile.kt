package com.bassamkhafagy.hafez.util

import android.util.Log
import com.bassamkhafagy.hafez.data.local.ImportedData
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.InputStream

fun parseImportedStudentsExcelFile(inputStream: InputStream): List<ImportedData> {
    val dataList = mutableListOf<ImportedData>()
    val workbook = XSSFWorkbook(inputStream)
    val sheet = workbook.getSheetAt(0) // Assuming data is in the first sheet

    try {
        for (rowIndex in sheet.firstRowNum + 1 until sheet.lastRowNum + 1) {
            val row = sheet.getRow(rowIndex)

            val studentCode =
                row.getCell(Constant.StudentExcel.STUDENT_CODE).numericCellValue.toLong()

            val studentName =
                row.getCell(Constant.StudentExcel.STUDENT_NAME_CODE).stringCellValue

            val ring = row.getCell(Constant.StudentExcel.STUDENT_RING).stringCellValue

            val sheikhName =
                row.getCell(Constant.StudentExcel.STUDENT_SHEIKH_NAME).stringCellValue

//        val phoneNumber =
//            row.getCell(Constant.StudentExcel.STUDENT_PHONE_NUMBER).stringCellValue

            val payState =
                row.getCell(Constant.StudentExcel.STUDENT_PAYING_STATE).stringCellValue

            Log.d("Excelll", payState)

            dataList.add(
                ImportedData(
                    studentCode,
                    studentName,
                    ring,
                    sheikhName,
                    null,
                    payState
                )

            )

        }
    } catch (e: Exception) {
        Log.e("ParsingException", e.message.toString())
    }
    return dataList
}