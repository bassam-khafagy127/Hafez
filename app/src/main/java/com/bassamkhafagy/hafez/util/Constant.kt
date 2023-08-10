package com.bassamkhafagy.hafez.util

object Constant {
    const val HAFEZ_DATABASE_NAME = "HAFEZ_DATABASE_NAME"
    const val SHUYUKH_DATABASE_TABLE_NAME = "SHUYUKH_DATABASE_TABLE_NAME"
    const val STUDENTS_DATABASE_TABLE_NAME = "STUDENTS_DATABASE_TABLE_NAME"
    const val SORA_COMPLETE_DATABASE_TABLE_NAME = "SORA_COMPLETE_DATABASE_TABLE_NAME"
    const val READ_REQUEST_CODE = 4554

    object StudentExcel {
        const val STUDENT_CODE = 0
        const val STUDENT_NAME_CODE = 1
        const val STUDENT_START_DATE_CODE = 2
        const val STUDENT_RING_CODE = 3
        const val STUDENT_PAYING_STATE_CODE = 4
    }

    object ReviewExcel {
        const val REVIEW_DATE = 0
        const val REVIEW_STUDENT_CODE = 1
        const val REVIEW_STUDENT_NAME_CODE = 2
        const val REVIEW_STUDENT_RING_CODE = 4
        const val REVIEW_Sheikh_CODE = 4
        const val REVIEW_SURAH_TITLE_CODE = 5
        const val REVIEW_STATE = 6
        const val REVIEW_DEGREE = 7
    }

    object SheikhExcel {
        const val SHEIKH_RING = 0
        const val SHEIKH_NAME = 1
        const val SHEIKH_PER_RING = 2

    }
}