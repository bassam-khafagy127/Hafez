package com.bassamkhafagy.hafez.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bassamkhafagy.hafez.util.Constant.STUDENTS_DATABASE_TABLE_NAME

@Entity(tableName = STUDENTS_DATABASE_TABLE_NAME)
data class Students(
    @PrimaryKey(autoGenerate = true)
    val code: Int,
    val studentsName: String?,
    val startDate: String?,
    val ring: String?,
    val payingState: String?,
    val phoneNumber: String?,
    val birthDate: String?,
)
